package com.example.arx.services;

import com.example.arx.model.AnonymizedDataRequest;
import com.example.arx.model.AnonymizedDataResponse;
import com.example.arx.model.Attribute;
import com.example.arx.model.PrivacyModel;
import org.deidentifier.arx.*;
import org.deidentifier.arx.criteria.DistinctLDiversity;
import org.deidentifier.arx.criteria.EntropyLDiversity;
import org.deidentifier.arx.criteria.KAnonymity;
import org.springframework.stereotype.Service;
import org.deidentifier.arx.criteria.PrivacyCriterion;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AnonymizeService {

    public List<String[]> anonymize(AnonymizedDataRequest request) {
        //TODO add more privacy models
        //TODO seperate functionality
        Data data = Data.create(request.getData());
        ARXAnonymizer anonymizer = new ARXAnonymizer();
        System.out.println(request);
        List<Attribute> attributes = request.getAttributes();
        for(Attribute attribute: attributes){
            data.getDefinition().setAttributeType(attribute.getField(),attribute.getAttributeType());
            System.out.println(attribute.getAttributeType());
            List<String[]> requestHierachy = attribute.getHierarchy();
            if(requestHierachy != null){
                AttributeType.Hierarchy hierarchy = AttributeType.Hierarchy.create(requestHierachy);
                data.getDefinition().setAttributeType(attribute.getField(),hierarchy);
            }
        }

        ARXConfiguration config = ARXConfiguration.create();
        Double suppressionLimit = request.getSuppresionLimit();
        List<PrivacyModel> privacyModels = request.getPrivacyModels();

        for(PrivacyModel model: privacyModels){
            System.out.println(model);
            config.addPrivacyModel(privacyCriterionFromModel(model));
        }

        if(suppressionLimit!=null){
            config.setSuppressionLimit(suppressionLimit);
        }

        try {
            ARXResult result = anonymizer.anonymize(data,config);
            return createResponseData(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PrivacyCriterion privacyCriterionFromModel(PrivacyModel privacyModel) {
        switch (privacyModel.getPrivacyModel()){
            case "KAnonymity":
                return new KAnonymity(Integer.parseInt(privacyModel.getParameters().get("k")));
            default:
                return null;
        }
    }

    private List<String[]> createResponseData(ARXResult result) {
        DataHandle handle = result.getOutput();
        List<String[]>responseData = new ArrayList<>();
        handle.iterator().forEachRemaining(responseData::add);
        return responseData;
    }


}

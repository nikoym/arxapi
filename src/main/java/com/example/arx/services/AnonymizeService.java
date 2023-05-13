package com.example.arx.services;

import com.example.arx.model.AnonymizedDataRequest;
import com.example.arx.model.Attribute;
import com.example.arx.model.PrivacyModel;
import org.deidentifier.arx.*;
import org.deidentifier.arx.criteria.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @Service
    public class AnonymizeService {

        /**
         *
         * @param request
         * @return
         * @throws IOException
         */
        public List<String[]> anonymize(AnonymizedDataRequest request) throws IOException {
            ARXAnonymizer anonymizer = new ARXAnonymizer();
            Data data = Data.create(request.getData());
            setAttributeTypes(data.getDefinition(), request.getAttributes());
            ARXConfiguration config = createConfiguration(request.getPrivacyModels(), request.getSuppresionLimit());
            ARXResult result = anonymizer.anonymize(data, config);
            return createResponseData(result);
        }

        private void setAttributeTypes(DataDefinition definition, List<Attribute> attributes) {
            for (Attribute attribute : attributes) {
                definition.setAttributeType(attribute.getField(), attribute.getAttributeTypeEnum().getAttributeType());
                List<String[]> requestHierachy = attribute.getHierarchy();
                if (requestHierachy != null) {
                    AttributeType.Hierarchy hierarchy = AttributeType.Hierarchy.create(requestHierachy);
                    definition.setAttributeType(attribute.getField(), hierarchy);
                }
            }
        }

        private ARXConfiguration createConfiguration(List<PrivacyModel> privacyModels, double suppressionLimit) {
            ARXConfiguration config = ARXConfiguration.create();
            for (PrivacyModel model : privacyModels) {
                PrivacyCriterion privacyCriterion = privacyCriterionFromModel(model);
                if(privacyCriterion != null){
                    config.addPrivacyModel(privacyCriterion);
                }
            }
            config.setSuppressionLimit(suppressionLimit);
            return config;
        }

        private PrivacyCriterion privacyCriterionFromModel(PrivacyModel privacyModel) {
            switch (privacyModel.getPrivacyModel()) {
                case "KAnonymity":
                    return new KAnonymity(Integer.parseInt(privacyModel.getParameters().get("k")));
                case "DistinctLDiversity":
                    return new DistinctLDiversity(privacyModel.getParameters().get("attribute"),
                            Integer.parseInt(privacyModel.getParameters().get("l")));
                case "EntropyLDiversity":
                    return new EntropyLDiversity(privacyModel.getParameters().get("attribute"),
                            Integer.parseInt(privacyModel.getParameters().get("l")));
                case "RecursiveCLDiversity":
                    return new RecursiveCLDiversity(privacyModel.getParameters().get("attribute"),
                            Integer.parseInt(privacyModel.getParameters().get("l")),
                            Integer.parseInt(privacyModel.getParameters().get("c")));
                case "EqualDistanceTCloseness":
                    return new EqualDistanceTCloseness(privacyModel.getParameters().get("attribute"),
                            Double.parseDouble(privacyModel.getParameters().get("t")));
                default:
                    return null;
            }
        }

        private List<String[]> createResponseData(ARXResult result) {
            DataHandle handle = result.getOutput();
            List<String[]> responseData = new ArrayList<>();
            if (handle != null) {
                handle.iterator().forEachRemaining(responseData::add);
            }
            return responseData;
        }

    }

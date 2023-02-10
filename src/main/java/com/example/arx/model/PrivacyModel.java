package com.example.arx.model;

import org.deidentifier.arx.criteria.PrivacyCriterion;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class PrivacyModel {

    private String privacyModel;
    private Map<String, String> parameters;

    public PrivacyModel(@RequestBody String privacyModel,@RequestBody Map<String, String> parameters) {
        this.privacyModel = privacyModel;
        this.parameters = parameters;
    }

    public String getPrivacyModel() {
        return privacyModel;
    }

    public void setPrivacyModel(String privacyModel) {
        this.privacyModel = privacyModel;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "PrivacyModel{" +
                "privacyModel='" + privacyModel + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}

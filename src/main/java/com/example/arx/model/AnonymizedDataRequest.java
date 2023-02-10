package com.example.arx.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AnonymizedDataRequest {
    private List<String[]> data;
    private List<Attribute> attributes;
    private List<PrivacyModel> privacyModels;
    private double suppresionLimit;

    public AnonymizedDataRequest(List<String[]> data, List<Attribute> attributes, List<PrivacyModel> privacyModels, double suppresionLimit) {
        this.data = data;
        this.attributes = attributes;
        this.privacyModels = privacyModels;
        this.suppresionLimit = suppresionLimit;
    }

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<PrivacyModel> getPrivacyModels() {
        return privacyModels;
    }

    public void setPrivacyModels(List<PrivacyModel> privacyModels) {
        this.privacyModels = privacyModels;
    }

    public double getSuppresionLimit() {
        return suppresionLimit;
    }

    public void setSuppresionLimit(double suppresionLimit) {
        this.suppresionLimit = suppresionLimit;
    }

    @Override
    public String toString() {
        return "AnonymizedDataRequest{" +
                "data=" + data +
                ", attributes=" + attributes +
                ", privacyModels=" + privacyModels +
                ", suppresionLimit=" + suppresionLimit +
                '}';
    }
}
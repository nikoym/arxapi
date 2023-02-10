package com.example.arx.model;

import java.util.List;
import org.deidentifier.arx.AttributeType;


public class Attribute {

    private String field;
    private AttributeType attributeType;
    private List<String[]> hierarchy;

    public Attribute(String field, AttributeType attributeType, List<String[]> hierarchy) {
        this.field = field;
        this.attributeType = attributeType;
        this.hierarchy = hierarchy;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public List<String[]> getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(List<String[]> hierarchy) {
        this.hierarchy = hierarchy;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "field='" + field + '\'' +
                ", attributeType=" + attributeType +
                ", hierarchy=" + hierarchy +
                '}';
    }
}

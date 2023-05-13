package com.example.arx.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.deidentifier.arx.AttributeType;


public class Attribute {

    private String field;
    private AttributeTypeEnum attributeTypeEnum;
    private List<String[]> hierarchy;

    public Attribute(String field,
                     AttributeTypeEnum attributeTypeEnum,
                     List<String[]> hierarchy) {
        this.field = field;
        this.attributeTypeEnum = attributeTypeEnum;
        this.hierarchy = hierarchy;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public AttributeTypeEnum getAttributeTypeEnum() {
        return attributeTypeEnum;
    }

    public void setAttributeTypeEnum(AttributeTypeEnum attributeTypeEnum) {
        this.attributeTypeEnum = attributeTypeEnum;
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
                ", attributeTypeEnum=" + attributeTypeEnum +
                ", hierarchy=" + hierarchy +
                '}';
    }
}

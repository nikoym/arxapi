package com.example.arx.model;

import org.deidentifier.arx.AttributeType;

public enum AttributeTypeEnum {
    SENSITIVE(AttributeType.SENSITIVE_ATTRIBUTE),
    INSENSITIVE(AttributeType.INSENSITIVE_ATTRIBUTE),
    IDENTIFYING(AttributeType.IDENTIFYING_ATTRIBUTE),
    QUASIIDENTIFYING(AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);

    private String name;
    private AttributeType attributeType;

    AttributeTypeEnum(AttributeType attributeType){
        this.name = attributeType.toString();
        this.attributeType = attributeType;
    }

    public String getName() {
        return name;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }
}

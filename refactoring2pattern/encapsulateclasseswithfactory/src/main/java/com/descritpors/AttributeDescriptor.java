package com.descritpors;

import java.lang.reflect.Type;

public class AttributeDescriptor {

    private final String descriptorName;
    private final Type mapperType;
    private final Type forType;

    public AttributeDescriptor(String descriptorName, Type mapperType, Type forType) {
        this.descriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }

    public String getDescriptorName() {
        return descriptorName;
    }
}

package factory.before;

import java.lang.reflect.Type;

public class ReferenceDescriptor extends AttributeDescriptor {
    private final String descriptorName;
    private final Type mapperType;
    private final Type forType;

    public ReferenceDescriptor(String descriptorName, Type mapperType, Type forType) {
        super(descriptorName, mapperType, forType);
        this.descriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }
}

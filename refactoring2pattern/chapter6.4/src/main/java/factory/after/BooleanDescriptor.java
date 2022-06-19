package factory.after;

import java.lang.reflect.Type;

public class BooleanDescriptor extends AttributeDescriptor {

    private final String descriptorName;
    private final Type mapperType;
    private final Type forType;

    public BooleanDescriptor(String descriptorName, Type mapperType, Type forType) {
        super(descriptorName, mapperType, forType);
        this.descriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }
}

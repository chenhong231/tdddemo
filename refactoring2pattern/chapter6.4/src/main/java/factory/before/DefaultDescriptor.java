package factory.before;

import java.lang.reflect.Type;

public class DefaultDescriptor extends AttributeDescriptor {

    private final String descriptorName;
    private final Type mapperType;
    private final Type forType;

    public DefaultDescriptor(String descriptorName, Type mapperType, Type forType) {
        super(descriptorName, mapperType, forType);
        this.descriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }
}

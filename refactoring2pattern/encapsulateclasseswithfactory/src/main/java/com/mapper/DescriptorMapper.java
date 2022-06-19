package com.mapper;

import com.descritpors.AttributeDescriptor;
import com.descritpors.DefaultDescriptor;
import com.descritpors.ReferenceDescriptor;
import com.domain.User;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class DescriptorMapper {

    protected List<AttributeDescriptor> createAttributeDescriptors() {

        List<AttributeDescriptor> result = new ArrayList<>();

        result.add(new DefaultDescriptor("remoteId", getClazz(), int.class));
        result.add(new DefaultDescriptor("createdDate", getClazz(), ZonedDateTime.class));
        result.add(new DefaultDescriptor("lastChangedDate", getClazz(), ZonedDateTime.class));
        result.add(new ReferenceDescriptor("createdBy", getClazz(), User.class));
        result.add(new ReferenceDescriptor("lastChangedBy", getClazz(), User.class));
        result.add(new DefaultDescriptor("optimisticLockVersion", getClazz(), int.class));

        return result;
    }

    private Type getClazz() {
        return DescriptorMapper.class;
    }
}

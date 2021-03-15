package com.mysite.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Configuration Service configure")
public @interface Configuration1 {

    @AttributeDefinition(
            name = "Student Limit",
            type = AttributeType.INTEGER)
    int get_studentlimit() default 10;

    @AttributeDefinition(
            name = "Passing Marks",
            type = AttributeType.INTEGER)
    int get_passingmarks() default 10;

}
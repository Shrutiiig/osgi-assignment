package com.mysite.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "StudentConfiguration")
public @interface Configuration {

    @AttributeDefinition(
            name = "Allowed students",
            type = AttributeType.INTEGER)
    int allowed_students() default 10;

    @AttributeDefinition(
            name = "Passing marks",
            type = AttributeType.INTEGER
    )
    int passing_marks() default 50;

    @AttributeDefinition(
            name = "Student ID",
            type = AttributeType.INTEGER
    )
    int student_id() default 1;

    @AttributeDefinition(
            name = "Student name",
            type = AttributeType.STRING
    )
    String student_name() default "Shruti";

    @AttributeDefinition(
            name = "Student marks",
            type = AttributeType.INTEGER
    )
    int student_marks() default 70;

    @AttributeDefinition(
            name = "Student age",
            type = AttributeType.INTEGER
    )
    int student_age() default 21;

}

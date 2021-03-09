package com.mysite.core.services.impl;

import com.mysite.core.services.ConfigurationService;
import com.mysite.core.services.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;


import com.mysite.core.services.Configuration;

import java.util.List;

@Component(service=ConfigurationService.class)
@Designate(ocd=Configuration.class)
public class ConfigurationServiceImpl implements ConfigurationService {

    private int allowedStudents;
    private int passingMarks;

    @Activate
    protected void activate(Configuration config) {
        allowedStudents = config.allowed_students();
        passingMarks = config.passing_marks();
    }


    @Override
    public boolean isClassLimitReached(List<Student> list) {
        return list.size() < allowedStudents;
    }

    @Override
    public int getPassingMarks() {
        return passingMarks;
    }

}

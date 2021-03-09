package com.mysite.core.services;

import java.util.List;

public interface ConfigurationService {


    boolean isClassLimitReached(List<Student> studentList);


    int getPassingMarks();

}

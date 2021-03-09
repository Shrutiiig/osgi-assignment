package com.mysite.core.services;

import java.util.ArrayList;
import java.util.List;

public interface StudentClassService extends ConfigurationService{
    List<Student> list = new ArrayList<>();

    void addStudent(int id, String name, int marks, int age);

    void deleteStudent(int id);

    boolean isStudentPassed(int id);

    Student getStudent(int id);

    List<Student> getAllStudents();

}

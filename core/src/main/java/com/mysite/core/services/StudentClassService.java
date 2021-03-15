package com.mysite.core.services;

import java.util.List;

public interface StudentClassService
{

    void  addStudent(Student student);
    void deleteStudent(int id);
    boolean isStudentPassed(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();

}

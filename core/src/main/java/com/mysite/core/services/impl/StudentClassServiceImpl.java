package com.mysite.core.services.impl;

import com.mysite.core.services.Configuration;
import com.mysite.core.services.Student;
import com.mysite.core.services.StudentClassService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service= StudentClassService.class)
@Designate(ocd=Configuration.class)
class StudentClassServiceImpl implements StudentClassService{

    private int allowedStudents;
    private int passingMarks;
    private int studentID;
    private String studentName;
    private int studentMarks;
    private int studentAge;

    @Activate
    protected void activate(Configuration config) {
        allowedStudents = config.allowed_students();
        passingMarks = config.passing_marks();
        studentID = config.student_id();
        studentName = config.student_name();
        studentMarks = config.student_marks();
        studentAge = config.student_age();
    }


    @Override
    public void addStudent(int id, String name, int marks, int age) {
        Student s = new Student(id, name, marks, age);
        if(list.size() < allowedStudents){
            list.add(s);
        }
    }

    @Override
    public void deleteStudent(int id) {
        if(list.size() > 0){
            int i = 0;
            while(i < list.size()){
                if(list.get(i).id == id){
                    list.remove(i);
                    break;
                }
                i++;
            }
        }

    }

    @Override
    public boolean isStudentPassed(int id) {
        int i = 0;
        while(i < list.size()){
            if(list.get(i).id == id){
                return list.get(i).marks_obtained > passingMarks;
            }
        }
        return false;
    }

    @Override
    public Student getStudent(int id) {
        int i = 0;
        while(i < list.size()){
            if(list.get(i).id == id){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return list;
    }

    @Override
    public boolean isClassLimitReached(List<Student> studentList) {
        return studentList.size() < allowedStudents;
    }

    @Override
    public int getPassingMarks() {
        return passingMarks;
    }
}

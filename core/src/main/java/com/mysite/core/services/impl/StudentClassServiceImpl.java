package com.mysite.core.services.implementation;

import com.mysite.core.services.Configuration2;
import com.mysite.core.services.ConfigurationService;
import com.mysite.core.services.Student;
import com.mysite.core.services.StudentClassService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import java.util.ArrayList;
import java.util.List;

@Component(service = {StudentClassService.class })
@Designate(ocd= Configuration2.class)
public class StudentClassServiceImpl implements StudentClassService
{
    private List<Student> studentList=new ArrayList<Student>();

    @Reference
    private ConfigurationService config;

    @Override
    public void addStudent(Student student) {

        if(! config.isClassLimitReached(studentList))
            studentList.add(student);
        else
            System.out.println("Student limit reached");
    }

    @Override
    public void deleteStudent(int id) {

        studentList.removeIf(s -> s.getId() == id);
    }

    @Override
    public boolean isStudentPassed(int id) {
        for(Student s: studentList)
        {
            if(s.getId()==id)
            {
                if(s.getMarks() >= config.getPassingMarks())
                {
                    return true;

                }
            }
        }
        return false;
    }

    @Override
    public Student getStudent(int id) {
        for(Student s: studentList)
        {
            if(s.getId()==id)
                return s;
        }

        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }
}

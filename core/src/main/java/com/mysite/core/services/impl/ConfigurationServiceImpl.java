package com.mysite.core.services.implementation;

import com.mysite.core.services.Configuration1;
import com.mysite.core.services.ConfigurationService;
import com.mysite.core.services.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service = ConfigurationService.class)
@Designate(ocd = Configuration1.class)
public class ConfigurationServiceImpl implements ConfigurationService {

    private int student_limit;
    private double passing_marks;

    @Activate
    public void activate(Configuration1 config)
    {
        student_limit=config.get_studentlimit();
        passing_marks=config.get_passingmarks();

    }


    @Override
    public boolean isClassLimitReached(List<Student> studentlist) {

        if(studentlist.size() !=0)
        {
            if (student_limit == studentlist.size())
                return true;
        }

        return false;
    }

    @Override
    public double getPassingMarks() {
        return passing_marks;
    }

}

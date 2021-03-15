/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mysite.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import com.mysite.core.services.ConfigurationService;
import com.mysite.core.services.Student;
import com.mysite.core.services.StudentClassService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/myservlet")
public class SimpleServlet extends SlingSafeMethodsServlet {



    private static final long serialVersionUID = 1L;

    @Reference
    private ConfigurationService configurationService;
    @Reference
    private StudentClassService studentClassService;

    @Override
    public void init() throws ServletException {
        studentClassService.addStudent(new Student(1, "Shruti", 23, 80));
        studentClassService.addStudent(new Student(2, "Aanya", 23, 90));
        studentClassService.addStudent(new Student(3, "Pratiksha", 23, 80.5));
        studentClassService.addStudent(new Student(4, "Anan", 23, 40));
        studentClassService.addStudent(new Student(5, "Prateek", 20, 70));
        studentClassService.addStudent(new Student(6, "Naman", 22, 50));
    }

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {


        int choice = Integer.parseInt(req.getParameter("choice"));
        int id ,age;
        String name;
        double marks;
        switch(choice)
        {
            case 1 :
                resp.getWriter().println("LIST INITIALLY  :" + studentClassService.getAllStudents());
                id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");
                age= Integer.parseInt(req.getParameter("age"));
                marks = Double.parseDouble(req.getParameter("marks"));
                studentClassService.addStudent(new Student(id,name,age,marks));
                resp.getWriter().println("Student added");
                resp.getWriter().println("List of student after manipulation :" +studentClassService.getAllStudents());
                break;
            case 2 :

                resp.getWriter().println("List of student :" +studentClassService.getAllStudents());
                break;

            case 3 : resp.getWriter().println("LIST INITIALLY  :" + studentClassService.getAllStudents());
                id = Integer.parseInt(req.getParameter("id"));
                resp.getWriter().println("Student info with given id  :" +studentClassService.getStudent(id));
                break;

            case 4 :  resp.getWriter().println("LIST INITIALLY  :" + studentClassService.getAllStudents());
                id = Integer.parseInt(req.getParameter("id"));
                studentClassService.deleteStudent(id);
                resp.getWriter().println("Student deleted");
                resp.getWriter().println("List of student after manipulation :" +studentClassService.getAllStudents());
                break;

            case 5:
                resp.getWriter().println("LIST INITIALLY  :" + studentClassService.getAllStudents());
                id = Integer.parseInt(req.getParameter("id"));
                resp.getWriter().println("Is the student with given id passed : "+studentClassService.isStudentPassed(id));
                break;

            case 6 :   resp.getWriter().println("Passing marks : "+ configurationService.getPassingMarks());
                break;

            default: resp.getWriter().println("Enter a valid choice");
        }

    }
}
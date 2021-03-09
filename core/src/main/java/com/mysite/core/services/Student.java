package com.mysite.core.services;

public class Student {
    public int id;
    public String name;
    public int age;
    public int marks_obtained;

    public Student(int id, String name, int marks_obtained, int age){
        this.id = id;
        this.name = name;
        this.marks_obtained = marks_obtained;
        this.age = age;
    }
}

package com.mysite.core.services;

public class Student {
    int id;
    String name;
    int age;
    double marks;

    public Student(int id ,String  name , int age , double marks ){
        this.id=id;
        this.name=name;
        this.age=age;
        this.marks=marks;
    }

    public String toString()
    {
        return "Name : "
                +name+" Id : "+id+" Age : "+" Marks : "+marks;
    }
    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }
}


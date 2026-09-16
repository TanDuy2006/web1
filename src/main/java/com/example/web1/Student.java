package com.example.web1;

public class Student {
    private int id;
    private String name;
    private int age;

    // Constructor đầy đủ tham số
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Constructor không tham số
    public Student() {
    }

    // Getter và Setter cho ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
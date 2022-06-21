package com.example.myapp05;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String age;
    private String major;
    private String id;
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", major='" + major + '\'' + ", id='" + id + '\'' + ", tel='" + tel + '\'' + '}';
    }
}

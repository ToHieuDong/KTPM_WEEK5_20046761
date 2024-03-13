package com.example.mq.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private String maSo;
    private String fullName;

    public Student(String maSo, String fullName) {
        this.maSo = maSo;
        this.fullName = fullName;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "maSo='" + maSo + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

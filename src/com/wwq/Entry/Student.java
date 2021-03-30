package com.wwq.Entry;

import java.util.Objects;

/**
 * 学生对象
 * @author wwq
 * @date 2021/3/29-17:15
 */
public class Student {
    private String name;
    private char sex;
    private int age;
    private String classId;
    private String stuId;

    public Student() {
    }

    public Student(String name, char sex, int age, String classId, String stuId) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classId = classId;
        this.stuId = stuId;
    }

    public Student(String classId, String stuId) {
        this.classId = classId;
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return getClassId().equals(student.getClassId()) && getStuId().equals(student.getStuId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSex(), getAge(), getClassId(), getStuId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", classId=" + classId +
                ", stuId=" + stuId +
                '}';
    }
}

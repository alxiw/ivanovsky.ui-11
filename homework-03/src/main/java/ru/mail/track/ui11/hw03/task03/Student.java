package ru.mail.track.ui11.hw03.task03;

/**
 * Класс, описывающий сущность Student, состоящую из
 * ФИО студента, факультета и номера курса
 */
public class Student {

    private String name;
    private String department;
    private int course;

    public Student(String name, String department, int course) {
        this.name = name;
        this.department = department;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

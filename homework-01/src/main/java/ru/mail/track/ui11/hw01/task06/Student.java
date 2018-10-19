package ru.mail.track.ui11.hw01.task06;

/**
 * Класс, описывающий сущность Student
 */
public class Student {

    private String name;
    private String faculty;

    public Student(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

}

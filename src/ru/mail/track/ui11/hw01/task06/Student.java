package ru.mail.track.ui11.hw01.task06;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int compareTo(Object o) {
        return 0;
    }
}

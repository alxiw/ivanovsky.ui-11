package ru.mail.track.ui11.hw05.task03.enumeration;

public enum Assessement {

    PROS("Плюсы"),
    CONS("Минусы");

    private final String name;

    Assessement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package ru.mail.track.ui11.hw04.task03.enumeration;

public enum Gender {

    MALE("Мужские"),
    FEMALE("Женские"),
    ALL("Все");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

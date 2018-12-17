package ru.mail.track.ui11.hw07.task01.enumeration;

public enum Section {

    POLITICS("Политика"),
    ECONIMICS("Экономика"),
    SOCIETY("Общество"),
    INCIDENT("События");

    private final String name;

    Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

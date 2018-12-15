package ru.mail.track.ui11.hw05.task03.enumeration;

public enum UrlCarType {

    SEDAN("sedan"),
    WAGON("wagon"),
    HATCHBACK("hatchback"),
    OFFROAD("offroad");

    private final String name;

    UrlCarType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

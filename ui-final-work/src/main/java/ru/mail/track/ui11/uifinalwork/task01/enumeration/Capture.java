package ru.mail.track.ui11.uifinalwork.task01.enumeration;

public enum Capture {

    NUMBER("Число дня"),
    RUNA("Руна дня"),
    MOON("Луна сегодня"),
    CARD("Карта дня");

    private final String name;

    Capture(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

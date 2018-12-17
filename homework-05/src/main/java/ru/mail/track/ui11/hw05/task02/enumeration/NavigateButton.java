package ru.mail.track.ui11.hw05.task02.enumeration;

public enum NavigateButton {

    PREV("prev"),
    NEXT("next");

    private final String name;

    NavigateButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

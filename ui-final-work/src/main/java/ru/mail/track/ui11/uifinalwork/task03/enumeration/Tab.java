package ru.mail.track.ui11.uifinalwork.task03.enumeration;

public enum Tab {

    POP("популярные"),
    NEW("новые");

    private final String name;

    Tab(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

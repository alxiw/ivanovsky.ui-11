package ru.mail.track.ui11.hw05.task04.enumeration;

public enum Article {

    RUS_TEAM("32246552");

    private final String name;

    Article(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

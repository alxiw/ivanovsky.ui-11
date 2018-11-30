package ru.mail.track.ui11.hw04.data;

public enum BrowsersData {

    Chrome("Google Chrome");

    private final String name;

    BrowsersData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
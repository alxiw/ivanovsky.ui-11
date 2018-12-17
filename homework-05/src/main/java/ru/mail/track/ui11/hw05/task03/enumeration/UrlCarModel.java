package ru.mail.track.ui11.hw05.task03.enumeration;

public enum UrlCarModel {

    FOCUS("focus"),
    FIESTA("fiesta"),
    MONDEO("mondeo"),
    KUGA("kuga"),
    EXPLORER("explorer");

    private final String name;

    UrlCarModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

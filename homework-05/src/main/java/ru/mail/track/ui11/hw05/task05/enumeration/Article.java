package ru.mail.track.ui11.hw05.task05.enumeration;

public enum Article {

    RAZ("nyanya-dlya-sobak-i-koshek-kak-podgotovitsya-k-raz");

    private final String name;

    Article(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

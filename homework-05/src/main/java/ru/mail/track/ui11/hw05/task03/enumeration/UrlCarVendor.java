package ru.mail.track.ui11.hw05.task03.enumeration;

public enum UrlCarVendor {

    AUDI("audi"),
    BMW("bmw"),
    FORD("ford"),
    HONDA("honda"),
    HYUNDAI("hyundai"),
    KIA("kia"),
    LADA("lada"),
    MAZDA("mazda"),
    MERCEDES("mercedes-benz"),
    MITSUBISHI("mitsubishi"),
    NISSAN("nissan"),
    RENAULT("renault"),
    SKODA("skoda"),
    TOYOTA("toyota"),
    VOLKSWAGEN("volkswagen");

    private final String name;

    UrlCarVendor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

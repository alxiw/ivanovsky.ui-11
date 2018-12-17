package ru.mail.track.ui11.hw07.task01.enumeration;

public enum Service {

    OK("Одноклассники"),
    VK("ВКонтакте"),
    FACEBOOK("Facebook"),
    TWITTER("Twitter");

    private final String name;

    Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

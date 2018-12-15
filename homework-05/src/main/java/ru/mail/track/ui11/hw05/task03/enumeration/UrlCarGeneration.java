package ru.mail.track.ui11.hw05.task03.enumeration;

public enum UrlCarGeneration {

    SIXTH_RS("vi_restailing"),
    SIXTH("vi"),
    FIFTH_RS("v_restailing"),
    FIFTH("v"),
    FOURTH_RS("iv_restailing"),
    FOURTH("iv"),
    THIRD_RS("iii_restailing"),
    THIRD("iii"),
    SECOND_RS("ii_restailing"),
    SECOND("ii"),
    FIRST_USA("i_usa"),
    FIRST("i");

    private final String name;

    UrlCarGeneration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

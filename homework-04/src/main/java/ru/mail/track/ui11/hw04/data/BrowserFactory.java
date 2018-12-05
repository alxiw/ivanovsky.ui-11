package ru.mail.track.ui11.hw04.data;

public class BrowserFactory {

    public static BrowsersData getBrowser(String browser) {

        switch (browser) {
            case "chrome":
                return BrowsersData.Chrome;
            default:
                return null;
        }
    }
}

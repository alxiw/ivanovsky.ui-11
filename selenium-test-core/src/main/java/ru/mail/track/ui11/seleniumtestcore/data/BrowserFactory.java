package ru.mail.track.ui11.seleniumtestcore.data;

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

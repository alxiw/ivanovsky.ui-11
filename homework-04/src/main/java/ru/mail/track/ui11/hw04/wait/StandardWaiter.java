package ru.mail.track.ui11.hw04.wait;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardWaiter {

    private WebDriver driver = null;

    public StandardWaiter(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait")) / 1000);
        try {
            wait.until(condition);
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

}

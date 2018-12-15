package ru.mail.track.ui11.hw05.task03;

import org.junit.Test;
import ru.mail.track.ui11.hw05.BaseTest;
import ru.mail.track.ui11.hw05.task03.enumeration.*;

public class CarsMailPageTest extends BaseTest {

    @Test
    public void check_accessibility_of_popup_with_car_assessment() {
        new CarsMailPage(driver)
                .open("catalog", UrlCarVendor.FORD.getName(), UrlCarModel.FOCUS.getName(), UrlCarGeneration.THIRD_RS.getName(), UrlCarType.SEDAN.getName())
                .checkThatThereAreNoOnePopupOnThePage()
                .clickAssessment(Assessement.PROS, "Управляемость")
                .popupShallBePresent()
                .checkPopupTitle()
                .closePopup()
                .checkThatThePopupIsClosed();
    }
}

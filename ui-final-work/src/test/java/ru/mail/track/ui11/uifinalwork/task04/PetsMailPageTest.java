package ru.mail.track.ui11.uifinalwork.task04;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PetsMailPageTest {

    @Test
    @DisplayName("Check Consultations List View")
    public void check_consultations_list_view() {
        new PetsMailPage()
                .open()
                .findSlider()
                .clickAnyConsultantOnThePage()
                .checkConsultantName();
    }
}
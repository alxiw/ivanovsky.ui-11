package ru.mail.track.ui11.hw06.task01;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RatingTopMailPageTest {

    @Test
    @DisplayName("Check Pagination")
    public void check_pagination_validity_on_the_page() {
        String pattern = "http[s]?://top.mail.ru/Rating/All/Today/Visitors/";
        int index = 8;

        RatingTopMailPage page = new RatingTopMailPage();

        List<String> numbersOnFirstPage = page.open()
                .checkPageUrl(pattern)
                .getListWithNumbersOnPage();

        List<String> numbersOnAnotherPage = page.clickPageNumber(index)
                .checkPageUrl(pattern + index + ".html")
                .getListWithNumbersOnPage();

        List<String> numbersOnFirstPageAgain = page.open()
                .checkPageUrl(pattern)
                .getListWithNumbersOnPage();

        assertEquals(numbersOnFirstPage.size(), numbersOnAnotherPage.size());
        assertNotEquals(numbersOnFirstPage, numbersOnAnotherPage);
        assertEquals(numbersOnFirstPage, numbersOnFirstPageAgain);
    }
}
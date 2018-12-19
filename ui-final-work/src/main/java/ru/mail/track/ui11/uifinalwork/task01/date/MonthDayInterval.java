package ru.mail.track.ui11.uifinalwork.task01.date;

import java.time.Month;
import java.time.MonthDay;

public class MonthDayInterval {

    private static MonthDay LAST = MonthDay.of(Month.DECEMBER, 31);
    private static MonthDay FIRST = MonthDay.of(Month.JANUARY, 1);

    private MonthDay begin;
    private MonthDay end;

    public MonthDayInterval(MonthDay begin, MonthDay end) {
        this.begin = begin;
        this.end = end;
    }

    public boolean isMonthDayBelongToTheInterval(MonthDay md) {
        return end.isBefore(begin) && begin.isBefore(LAST) && end.isAfter(FIRST) ?
                isAfterOrEqualsBeginAndBeforeOrEqualsEnd(md, begin, LAST) || isAfterOrEqualsBeginAndBeforeOrEqualsEnd(md, FIRST, end) :
                isAfterOrEqualsBeginAndBeforeOrEqualsEnd(md, begin, end);
    }

    private boolean isAfterOrEquals(MonthDay one, MonthDay two) {
        return one.isAfter(two) || one.equals(two);
    }

    private boolean isBeforeOrEquals(MonthDay one, MonthDay two) {
        return one.isBefore(two) || one.equals(two);
    }

    private boolean isAfterOrEqualsBeginAndBeforeOrEqualsEnd(MonthDay md, MonthDay begin, MonthDay end) {
        return isAfterOrEquals(md, begin) && isBeforeOrEquals(md, end);
    }
}
package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TestAdjusters {
    public static void main(String[] args) {
        int year = 2024;
        int month = 1;

        LocalDate localDate = LocalDate.of(year, month, 1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("firstDayOfWeek = " + dayOfWeek);

        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        DayOfWeek lastDayOfWeek = lastDay.getDayOfWeek();
        System.out.println("lastDayOfWeek = " + lastDayOfWeek);

    }
}

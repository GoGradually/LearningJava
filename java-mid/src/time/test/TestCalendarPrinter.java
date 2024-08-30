package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCalendarPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        int month;
        System.out.println("년도를 입력하세요: ");
        year = scanner.nextInt();
        System.out.println("월을 입력하세요");
        month = scanner.nextInt();

        int arr[][] = new int[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = 0;
            }
        }

        LocalDate startDate = LocalDate.of(year, month, 1);
        int cntDay = startDate.getDayOfWeek().getValue() % 7;
        LocalDate lastDate = startDate.plusMonths(1).minusDays(1);
        int lastDay = lastDate.getDayOfMonth();
        for (int i = 0; i < lastDay; i++) {
            int x = (i + cntDay) / 7;
            int y = (i + cntDay) % 7;
            arr[x][y] = i + 1;
        }

        System.out.println("Su Mo Tu We Th Fr Sa");
        for (int[] integers : arr) {
            for (int day : integers) {
                if(day == 0){
                    System.out.print("   ");
                }else{
                    System.out.printf("%2d ", day);
                }
            }
            System.out.println();
        }
    }
}

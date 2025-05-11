package lambda.ex1;

import java.util.Arrays;

public class M3After {

    public static void main(String[] args) {
        Procedure sum = new Procedure() {
            @Override
            public void run() {
                int number = 100;
                int sum = 0;
                for (int i = 1; i <= number; i++) {
                    sum += i;
                }
                System.out.println("sum = " + sum);
            }
        };

        Procedure sort = new Procedure() {
            @Override
            public void run() {
                int[] arr = {4, 3, 2, 1};
                System.out.println("원본 배열: " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("배열 정렬: " + Arrays.toString(arr));
            }
        };

        measure(sum);
        measure(sort);

    }
    static void measure(Procedure procedure) {
        long start = System.nanoTime();
        procedure.run();
        long end = System.nanoTime();
        System.out.println("실행 시간: " + (end- start) + "ns");
    }


    private interface Procedure{
        void run();
    }

}

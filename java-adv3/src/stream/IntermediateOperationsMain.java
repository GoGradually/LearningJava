package stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class IntermediateOperationsMain {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10);

        integers.stream().filter(integer -> integer % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");


        System.out.println("distinct - 중복 제거");
        integers.stream()
                .distinct()
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("sorted - 기본 정렬");
        Stream.of(1, 3, 1, 5, 6, 4, 1, 23, 4, 2, 6, 3, 2, 2)
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("sorted - 커스텀 정렬 Comparator");
        Stream.of(3, 1, 3, 2, 5, 56, 1, 3, 5, 12)
                .sorted(reverseOrder())
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("peek - 동작 확인용");
        integers.stream()
                .peek(n -> System.out.print("before: " + n + " "))
                .map(n -> n * n)
                .peek(n -> System.out.print("after: " + n + " "))
                .forEach(n -> System.out.println("result: " + n + " "));
        System.out.println("\n");

        System.out.println("limit - 처음 5개 요소만");
        integers.stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("skip - 처음 5개 요소 건너뛰기");
        integers.stream().skip(5).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        List<Integer> integers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println("takeWhile - 조건에 만족하는 동안만 사용 (java 9+) (filter랑 헷갈리지 않기)");
        integers2.stream().takeWhile(n -> n <= 3).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("dropWhile - 조건을 불만족할 때까지 버림 (java 9+)");
        integers2.stream().dropWhile(n -> n <= 3).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
        IntStream intStream = integers2.stream().mapToInt(n -> n);
    }
}

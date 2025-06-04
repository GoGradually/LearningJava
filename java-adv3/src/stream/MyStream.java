package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    private final List<T> list;

    private MyStream(List<T> list) {
        this.list = list;
    }

    public static <T> MyStream<T> of(List<T> list) {
        return new MyStream<>(list);
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return new MyStream<>(newList);
    }

    public <R> MyStream<R> map(Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(function.apply(t));
        }
        return new MyStream<>(newList);
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public List<T> toList() {
        return list;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println("================My Stream 시작================");
        Optional<Integer> myFirst = MyStream.of(integers)
                .filter(n -> {
                    boolean isOdd = n % 2 == 1;
                    System.out.println("값 " + n + " 홀수 여부 확인: " + isOdd);
                    return isOdd;
                })
                .map(n -> {
                    int result = n * 2;
                    System.out.println("변환된 값 = " + n + "->" + result);
                    return result;
                }).findFirst();
        System.out.println("myFirst = " + myFirst.orElse(-1));
        System.out.println("================My Stream 종료================");

        System.out.println("================Java Stream 시작================");
        Optional<Integer> javaFirst = integers.stream()
                .filter(n -> {
                    boolean isOdd = n % 2 == 1;
                    System.out.println("값 " + n + " 홀수 여부 확인: " + isOdd);
                    return isOdd;
                })
                .map(n -> {
                    int result = n * 2;
                    System.out.println("변환된 값 = " + n + "->" + result);
                    return result;
                }).findFirst();
        System.out.println("javaFirst = " + javaFirst.orElse(-1));
        System.out.println("================Java Stream 종료================");
    }

    public Optional<T> findFirst() {
        return Optional.ofNullable(list.getFirst());
    }


}





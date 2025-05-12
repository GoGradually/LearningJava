package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamV1<T> {
    private final List<T> list;

    private StreamV1(List<T> list) {
        this.list = list;
    }

    public static <T> StreamV1<T> of(List<T> list) {
        return new StreamV1<>(list);
    }

    public StreamV1<T> filter(Predicate<T> predicate){
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return new StreamV1<>(newList);
    }

    public <R> StreamV1<R> map(Function<T, R> function){
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(function.apply(t));
        }
        return new StreamV1<>(newList);
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
        StreamV1.of(integers)
                .filter(n -> n % 2 == 1)
                .map(n -> n * 2)
                .forEach(System.out::println);
    }
}





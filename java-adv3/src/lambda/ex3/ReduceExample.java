package lambda.ex3;

import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);

        int plus = reduce(integers, 0, Integer::sum);
        System.out.println(plus);

        int product = reduce(integers, 1, (a, b) -> a * b);
        System.out.println(product);

    }

    static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;
        for (Integer i : list) {
            result = reducer.reduce(i, result);
        }
        return result;
    }

    private interface MyReducer {
        int reduce(int a, int b);
    }
}

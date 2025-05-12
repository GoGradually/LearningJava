package lambda.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class FilterExample {
    public static void main(String[] args) {

        List<Integer> list = List.of(-3, -2, -1, 1, 2, 3, 5);

        List<Integer> negative = filter(list, x -> x < 0);
        System.out.println("negative = " + negative);

        List<Integer> positive = filter(list, x -> x > 0);
        System.out.println("positive = " + positive);

        List<Integer> even = filter(list, x -> x % 2 == 0);
        System.out.println("even = " + even);
    }

    static List<Integer> filter(List<Integer> list, IntPredicate p) {
        List<Integer> result = new ArrayList<>();
        for (int i : list) {
            if (p.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
}

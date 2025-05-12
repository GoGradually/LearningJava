package lambda.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExample {

    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");

        System.out.println("list = " + list);

        List<String> toUpper = map(list, String::toUpperCase);
        System.out.println("toUpper = " + toUpper);

        List<String> toStarDeco = map(list, str -> "***" + str + "***");
        System.out.println("toStarDeco = " + toStarDeco);
    }


    static List<String> map(List<String> list, UnaryOperator<String> func){
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(func.apply(s));
        }
        return result;
    }

}


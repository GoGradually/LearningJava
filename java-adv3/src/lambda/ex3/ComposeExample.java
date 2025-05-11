package lambda.ex3;

public class ComposeExample {

    public static void main(String[] args) {

        MyTransformer compose = compose(String::toUpperCase, str -> "**" + str + "**");
        System.out.println(compose.transform("hello"));

    }

    static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return str -> f2.transform(f1.transform(str));
    }

    @FunctionalInterface
    private interface MyTransformer{
        String transform(String word);
    }
}

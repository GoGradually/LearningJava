package lambda.ex3;

public class BuildGreeterExample {
    public static void main(String[] args) {
        StringFunction hello = buildGreeter("Hello");
        String word1 = hello.apply("world");
        System.out.println(word1);

        StringFunction hi = buildGreeter("Hi");
        String word2 = hi.apply("Lambda");
        System.out.println(word2);
    }

    static StringFunction buildGreeter(String keyword) {
        return input -> String.format("%s, %s!", keyword, input);
    }


    private interface StringFunction {
        String apply(String value);
    }
}

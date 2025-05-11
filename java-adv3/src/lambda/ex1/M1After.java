package lambda.ex1;

public class M1After {

    public static void main(String[] args) {
        MyPrintFunction myFunc = str -> {
            System.out.println("=== 시작 ===");
            System.out.println(str);
            System.out.println("=== 끝 ===");
        };
        myFunc.apply("Good Morning!");
        myFunc.apply("Good Afternoon!");
        myFunc.apply("Good Evening!");
    }

    private interface MyPrintFunction {
        void apply(String str);
    }
}

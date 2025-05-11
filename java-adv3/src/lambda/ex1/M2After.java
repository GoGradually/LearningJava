package lambda.ex1;

public class M2After {
    public static void main(String[] args) {
        MyPrintFunction myFunc = (str, unit) -> System.out.println("무게: " + str + unit);
        myFunc.apply("10", "kg");
        myFunc.apply("50", "kg");
        myFunc.apply("200","g" );
        myFunc.apply("40","g" );

    }

    private interface MyPrintFunction {
        void apply(String str, String unit);
    }

}

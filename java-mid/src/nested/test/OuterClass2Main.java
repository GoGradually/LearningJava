package nested.test;

public class OuterClass2Main {
    public static void main(String[] args) {
        OuterClass2.InnerClass inner = new OuterClass2().new InnerClass();
        inner.hello();
    }
}

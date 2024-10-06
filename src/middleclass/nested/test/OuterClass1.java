package middleclass.nested.test;

public class OuterClass1 {
    static class NestedClass {
        public void hello() {
            System.out.println("NestedClass.hello");
        }
    }

    public static void main(String[] args) {
        NestedClass nestedClass = new NestedClass();
        nestedClass.hello();
    }
}

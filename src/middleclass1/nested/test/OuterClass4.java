package middleclass1.nested.test;

public class OuterClass4 {
    interface Hello {
        void hello();
    }
    public static void main(String[] args) {
        Hello hello = new Hello() {

            @Override
            public void hello() {
                System.out.println("OuterClass4.hello");
            }
        };


        hello.hello();
    }
}

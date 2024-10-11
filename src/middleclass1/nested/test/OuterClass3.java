package middleclass1.nested.test;

public class OuterClass3 {
    public void myMethod() {
        class LocalClass {
            public void hello() {
                System.out.println("LocalClass.hello");
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.hello();
    }

    public static void main(String[] args) {
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.myMethod();
    }

}

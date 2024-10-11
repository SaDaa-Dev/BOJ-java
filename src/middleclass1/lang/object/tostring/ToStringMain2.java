package middleclass1.lang.object.tostring;

public class ToStringMain2 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 4);

        System.out.println("다형성 활용");
        ObjectPrinter.print(dog1);
        ObjectPrinter.print(dog2);
    }
}
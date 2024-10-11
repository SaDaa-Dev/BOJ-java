package middleclass1.lang.object.poly;

public class ObjectPolyExample2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        Object o = new Object();
        Object[] objects = {dog, car, o};

        size(objects);

    }

    private static void size(Object[] objects) {
        System.out.println("전달된 객체 수는 : " + objects.length);
    }
}

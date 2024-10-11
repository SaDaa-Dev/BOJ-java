package middleclass2.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();

        integerBox.set(10);
        Integer re = integerBox.get();
        System.out.println("re = " + re);
    }
}

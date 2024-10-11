package middleclass2.generic.ex1;

public class BoxMain2 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.setValue(10);
        Integer integer = (Integer) integerBox.getValue();
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.setValue("hello");
        String str = (String) stringBox.getValue();
        System.out.println("str = " + str);
    }
}

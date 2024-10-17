package middleclass2.collection.set;

public class MyHashSetV0Main {
    public static void main(String[] args) {
        MyHashSetV0 set = new MyHashSetV0();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set);

        boolean result = set.add(4);
        System.out.println("result = " + result);
        System.out.println(set);
        System.out.println("set.contains(4) = " + set.contains(4));
    }
}

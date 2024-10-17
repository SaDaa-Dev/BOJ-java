package middleclass2.collection.set;

public class MyHashSetV2Main1 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("AB");
        set.add("SET");

        System.out.println("set = " + set);

        String searchValue = "SET";
        boolean result = set.contains(searchValue);
        System.out.println("result = " + result);
    }
}

package middleclass2.collection.link;

public class MyLinkedListV2Main {
    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        list.add(0, "d");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.add(1, "e");
        System.out.println(list);
    }
}

package middleclass2.collection.compare;

import java.util.TreeSet;

public class SortMain5 {
    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>(new IdComparator());
        treeSet1.add(myUser1);
        treeSet1.add(myUser2);
        treeSet1.add(myUser3);
        System.out.println(treeSet1);
    }
}

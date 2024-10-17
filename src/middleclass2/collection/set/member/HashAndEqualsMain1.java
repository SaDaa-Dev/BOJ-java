package middleclass2.collection.set.member;

import middleclass2.collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2();
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");

        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));


        set.add(m1);
        set.add(m2);

        System.out.println("set = " + set);

        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A");
        System.out.println("set.contains(searchValue) = " + set.contains(searchValue));

    }
}

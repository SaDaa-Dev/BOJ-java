package middleclass.lang.immutable.address;

public class RefMain1_2 {
    public static void main(String[] args) {
        //참조형 인스턴스 공유
        Address a = new Address("서울");
        Address b = new Address("서울");

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b.setValue("부산");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

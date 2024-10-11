package middleclass1.lang.immutable.address;

public class RefMain1_3 {
    public static void main(String[] args) {
        //참조형 인스턴스 공유
        Address a = new Address("서울");
        Address b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        change(b, "부산");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static void change(Address address, String changeAddress) {
        System.out.println("주소 값을 변경합니다. ");
        address.setValue(changeAddress);
    }
}

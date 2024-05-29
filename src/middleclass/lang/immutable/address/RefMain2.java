package middleclass.lang.immutable.address;

public class RefMain2 {
    public static void main(String[] args) {
        //참조형 인스턴스 공유
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // 새로운 객체를 만들어 넣어야 함, 불변 객체기 때문에
        b = new ImmutableAddress("부산");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

package poly.basic;

public class CastingMain2 {
    public static void main(String[] args) {
        Parent poly = new Child();

        // 다운 캐스팅 (부모 타입 -> 자식 타입)
        Child child = (Child) poly;
        child.childMethod();

        // 일시적 다운 캐스팅
        ((Child) poly).childMethod();

    }
}

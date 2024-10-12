package middleclass2.generic.test.ex3.unit;

public class UnitPrinter {
    public static <T extends BioUnit> void  printV1(Shuttle<T> t1) {
        // 제네릭
        T unit = t1.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

    public static void printV2(Shuttle<? extends BioUnit> t1) {
        // 와일드카드
        BioUnit unit = t1.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }
}

package middleclass1.enumeration.ex3;

public class EnumRefMain {
    public static void main(String[] args) {
        System.out.println("Grade.BASIC.getClass() = " + Grade.BASIC.getClass());
        System.out.println("Grade.GOLD.getClass() = " + Grade.GOLD.getClass());
        System.out.println("Grade.DIAMOND.getClass() = " + Grade.DIAMOND.getClass());

        System.out.println("Grade.BASIC = " + refValue(Grade.BASIC));
        System.out.println("Grade.GOLD = " + refValue(Grade.GOLD));
        System.out.println("Grade.DIAMOND = " + refValue(Grade.DIAMOND));
    }

    private static String refValue(Grade grade) {
        return Integer.toHexString(System.identityHashCode(grade));
    }
}

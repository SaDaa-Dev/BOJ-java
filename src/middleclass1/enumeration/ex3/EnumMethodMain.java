package middleclass1.enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {
    public static void main(String[] args) {
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));

        // String -> Enum 변환
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold);
    }
}

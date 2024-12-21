package programmers.level2.prac;

import java.util.Arrays;

public class MaxAndMin {
    public static void main(String[] args) {
        String input = "-1 -2 -3 -4";

        int[] array = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        System.out.println(array[0] + " " + array[array.length - 1]);
    }
}

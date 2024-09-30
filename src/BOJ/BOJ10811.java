package BOJ;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] numbers = IntStream.range(1, n + 1).toArray();

        for (int i = 0; i < m; i++) {
            String[] target = sc.nextLine().split(" ");
            int startN = Integer.parseInt(target[0]) - 1;
            int endN = Integer.parseInt(target[1]) - 1;

            while(startN < endN){
                int tmp = numbers[startN];
                numbers[startN++] = numbers[endN];
                numbers[endN--] = tmp;
            }
        }

        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        sc.close();

    }
}

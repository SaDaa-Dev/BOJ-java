import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nm = sc.nextLine().split(" ");// 바구니의 개수 입력 받기 1 ~ N
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = i + 1; // 바구니 배열 초기화

        for (int i = 0; i < m; i++) {
            String[] target = sc.nextLine().split(" ");
            int firstPos = Integer.parseInt(target[0]);
            int secondPos = Integer.parseInt(target[1]);

            // 교환 로직
            int tmp = numbers[firstPos - 1];
            numbers[firstPos - 1] = numbers[secondPos - 1];
            numbers[secondPos - 1] = tmp;
        }

        // 배열의 요소를 공백으로 구분하여 출력
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
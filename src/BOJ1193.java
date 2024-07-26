import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int current = 1;  // 현재 몇 번째 분수인지
        int level = 1;  // 대각선 레벨

        while (current + level < n) {
            current += level;
            level++;
        }

        int index = n - current;  // 현재 레벨에서 몇 번째인지

        // level이 홀수라면 분모가 더 크고 위에서 아래로 내려갑니다.
        // level이 짝수라면 분자가 더 크고 아래에서 위로 올라갑니다.
        if (level % 2 == 1) {
            System.out.println((level - index) + "/" + (index + 1));
        } else {
            System.out.println((index + 1) + "/" + (level - index));
        }
    }
}

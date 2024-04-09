import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] base = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int number = base[0];
        int formation = base[1];

        StringBuffer sb = new StringBuffer();

        while (number > 0) {
            int remain = number % formation;
            if (remain >= 10) {
                sb.append((char)('A' + (remain - 10)));
            } else {
                sb.append(remain);
            }
            number /= formation;
        }

        System.out.println(sb.reverse().toString());
    }
}

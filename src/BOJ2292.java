import javax.print.attribute.standard.PrinterMakeAndModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 1; // 거리
        int range = 2; // 범위

        if (n == 1) {
            System.out.println(1);
        } else {
            while (range <= n){
                range += (6 * result);
                result++;
            }
            System.out.println(result);
        }
    }
}

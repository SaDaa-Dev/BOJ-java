package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cross_cnt = 1, prev_cnt = 0;

        while (true) {

            if (n <= cross_cnt + prev_cnt) {
                if (cross_cnt % 2 == 1) {
                    System.out.println((cross_cnt - (n - prev_cnt - 1)) + "/" + (n - prev_cnt));
                    break;
                } else {
                    System.out.print((n - prev_cnt) + "/" + (cross_cnt - (n - prev_cnt - 1)));
                    break;
                }
            } else {
                prev_cnt += cross_cnt;
                cross_cnt++;
            }
        }


    }
}

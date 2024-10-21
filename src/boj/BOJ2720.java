package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coin = new int[] {25, 10, 5, 1};

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int usd = Integer.parseInt(br.readLine());
            for (int co : coin) {
                int quantity = usd / co;
                System.out.print(quantity + " ");
                usd %= co;
            }
        }
    }
}

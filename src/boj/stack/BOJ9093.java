package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                sb.append(new StringBuilder(str).reverse());

                if (j < strs.length - 1) {
                    sb.append(" ");
                }
            }

            System.out.println(sb.toString());
        }
    }
}

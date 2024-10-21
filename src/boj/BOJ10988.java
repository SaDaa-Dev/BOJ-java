package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int re = 1;

        for (int i = 1; i <= target.length() / 2; i++) {
            String frontC = target.substring(i - 1, i);
            String endC = target.substring(target.length() - i, target.length() - i + 1);

            if(!frontC.equals(endC)){
                re = 0;
                break;
            }
        }

        System.out.println(re);
    }
}

package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("-1")) {
                break;
            }

            int target = Integer.parseInt(str);
            int factors_sum = 0;

            List<Integer> factors = new LinkedList<>();

            for (int i = 1; i < target; i++) {
                if (target % i == 0) {
                    factors.add(i);
                    factors_sum += i;
                }
            }


            if (factors_sum != target) {
                System.out.println(target + " is NOT perfect.");
            } else {
                StringBuilder output = new StringBuilder();
                output.append(target).append(" = ");

                for (int i = 0; i < factors.size(); i++) {
                    output.append(factors.get(i));
                    if (i < factors.size() - 1) {
                        output.append(" + ");
                    }
                }

                System.out.println(output);
            }


        }
    }
}

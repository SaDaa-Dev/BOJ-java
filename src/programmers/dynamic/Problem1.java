package programmers.dynamic;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    private class Solution {
        public int solution(int N, int number) {
            Set<Integer>[] dp = new HashSet[9];

            for (int i = 1; i <= 8; i++) {
                dp[i] = new HashSet<>();
            }

            int num = 0;
            for (int i = 1; i <= 8; i++) {
                num = num * 10 + N;
                dp[i].add(num);
            }

            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j < i; j++) {
                    for (int a : dp[j]) {
                        for (int b : dp[i - j]) {
                            dp[i].add(a + b);
                            dp[i].add(a - b);
                            dp[i].add(a * b);
                            if (b != 0) {
                                dp[i].add(a / b);
                            }
                        }
                    }
                }

                if (dp[i].contains(number)) {
                    return i;
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) {
        Problem1 prom = new Problem1();
        Solution sol = prom.new Solution();
        System.out.println(sol.solution(5, 12));
    }
}

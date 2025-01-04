package programmers.level2.prac;

import java.util.ArrayList;

public class JumpToFar {
    private final int MOD = 1_234_567;
    // 2칸 OR 1칸 뛰었을 경우
    // BFS OR DFS OR 백 트래킹? 모든 경우의 수 => DFS OR 백트래킹이 적합하지 않을까
//    private int result = 0;
//    public long solution(int n) {
//        dfs(n, 0);
//        return result % MOD;
//    }
//
//    private void dfs(int n, int start) {
//        if (start > n) {
//            return;
//        }
//        if (start == n) {
//            result++;
//        }
//
//        dfs(n, start + 1); // 1칸 앞으로 갈 때
//        dfs(n, start + 2); // 2칸 앞으로 갈 때
//    }

    // 시간 초과 이후 새로운 Solution
    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        JumpToFar prom = new JumpToFar();
        System.out.println(prom.solution(3));
    }
}

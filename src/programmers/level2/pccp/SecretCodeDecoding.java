package programmers.level2.pccp;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecretCodeDecoding {
    private int m, n, answer;
    private int[] ans, pool;
    private int[][] q;
    private boolean[] present;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.m = ans.length;
        this.ans = ans;
        this.q = q;
        this.present = new boolean[n + 1];
        this.pool = makePool(ans, q);

        dfs(0, 0, new int[5]);

        return answer;
    }

    private void dfs(int start, int picked, int[] currCode) {
        if (picked == 5) {
            if(isValid()) answer++;
            return;
        }
        if(start == pool.length) return;
        if(picked + (pool.length - start) < 5) return;

        // 숫자 선택
        int num = pool[start];
        present[num] = true;
        currCode[picked] = num;
        dfs(start + 1, picked + 1, currCode);

        // 숫자 미선택
        present[num] = false;
        dfs(start + 1, picked, currCode);
    }

    private int[] makePool(int[] ans, int[][] q) {
        Set<Integer> cand = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());

        for (int t = 0; t < m; t++) {
            if (ans[t] == 0) {
                for (int num : q[t]) {
                    cand.remove(num);
                }
            }
        }

        return cand.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isValid() {
        for (int t = 0; t < m; t++) {
            int hit = 0;
            for (int num : q[t]) {
                if(present[num]) hit++;
            }

            if(hit != ans[t]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SecretCodeDecoding problem = new SecretCodeDecoding();
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};
        System.out.println("problem.solution(10, q, ans) = " + problem.solution(10, q, ans));
    }
}

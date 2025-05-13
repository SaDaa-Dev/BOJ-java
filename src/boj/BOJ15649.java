package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    private int n, m;
    private boolean[] used = new boolean[9];
    private int[] picked = new int[9];
    private StringBuilder sb = new StringBuilder();
    public void printComb(int n, int m) {
        this.n = n;
        this.m = m;

        dfs(0);

        System.out.println(sb);
    }

    private void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int num = 1; num <= n; num++) {
            if(used[num]) continue;
            used[num] = true;
            picked[depth] = num;

            dfs(depth + 1);
            used[num] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ15649 problem = new BOJ15649();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        problem.printComb(n, m);
    }
}

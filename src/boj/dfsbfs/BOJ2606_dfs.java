package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2606_dfs {
    public class Solution {
        private ArrayList<ArrayList<Integer>> adj;
        private boolean[] visited;
        private int currentSum;
        public int solution(ArrayList<ArrayList<Integer>> adj) {
            this.adj = adj;
            this.visited = new boolean[adj.size()];
            this.currentSum = 0;
            int start = 0;
            dfs(start);
            return currentSum;
        }

        public void dfs(int start) {
            visited[start] = true;
            for (Integer neighbor : adj.get(start)) {
                if (!visited[neighbor]) {
                    currentSum++;
                    dfs(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BOJ2606_dfs boj = new BOJ2606_dfs();
        Solution solution = boj.new Solution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int computerCnt = Integer.parseInt(br.readLine());
            int pareCnt = Integer.parseInt(br.readLine());

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(computerCnt);
            for (int i = 0; i < computerCnt; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < pareCnt; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int start = input[0] - 1;
                int end = input[1] - 1;

                adj.get(start).add(end);
                adj.get(end).add(start);
            }

            System.out.println(solution.solution(adj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

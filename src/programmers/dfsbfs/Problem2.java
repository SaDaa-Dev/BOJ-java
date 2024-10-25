package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public class Solution {
        private int n;
        private int[][] computers;
        private boolean[] visited;
        private List<List<Integer>> adj;
        private int netWorkCnt = 0;
        public int solution(int n, int[][] computers) {
            this.computers = computers;
            this.n = n;

            adj = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[i].length; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (computers[i][j] == 1) {
                        adj.get(i).add(j);
                    }
                }
            }
            System.out.println("adj.toString() = " + adj.toString());

            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    netWorkCnt++;
                }
            }

            return netWorkCnt;
        }

        public void dfs(int current) {
            visited[current] = true;

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    dfs(neighbor);
                }
            }

        }
    }


    public static void main(String[] args) {
        Problem2 prom = new Problem2();
        Solution solution = prom.new Solution();
        int result = solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println("result = " + result);
    }
}

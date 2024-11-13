package programmers.fullsearch;

import java.util.ArrayList;
import java.util.List;

// 전력망을 둘로 나누기
public class Problem6 {
    public class Solution {
        private static List<List<Integer>> adj = new ArrayList<>();
        private static boolean[] visited;
        private static int totalNodes;
        private int minResult = Integer.MAX_VALUE;

        public int solution(int n, int[][] wires) {
            totalNodes = n;
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] wire : wires) {
                int from = wire[0];
                int to = wire[1];

                adj.get(from).add(Integer.valueOf(to));
                adj.get(to).add(Integer.valueOf(from));
            }

            for (int[] wire : wires) {
                int delFrom = wire[0];
                int delTo = wire[1];

                adj.get(delFrom).remove(Integer.valueOf(delTo));
                adj.get(delTo).remove(Integer.valueOf(delFrom));

                visited = new boolean[n + 1];
                int subNodeCnt = dfs(delFrom);
                int parentNodeCnt = n - subNodeCnt;
                int diff = Math.abs(subNodeCnt - parentNodeCnt);
                minResult = Math.min(diff, minResult);

                adj.get(delFrom).add(delTo);
                adj.get(delTo).add(delFrom);
            }

            return minResult;
        }

        private int dfs(int current) {
            visited[current] = true;
            int count = 1;

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    count += dfs(neighbor);
                }
            }

            return count;
        }
    }
    public static void main(String[] args) {
        Problem6 programmers = new Problem6();
        Solution sol = programmers.new Solution();
        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        System.out.println(sol.solution(n, wires));;
    }
}

package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem4 {
    private class Solution {

        private int[] parent;
        private int[] rank;

        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (rank[rootA] < rank[rootB]) {
                    parent[rootA] = rootB;
                } else if (rank[rootA] > rank[rootB]) {
                    parent[rootB] = rootA;
                } else {
                    parent[rootB] = rootA;
                    rank[rootA]++;
                }
            }
        }
        public int solution(int n, int[][] costs) {
            Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            int totalCost = 0;
            int count = 0; // 간선

            for (int[] cost : costs) {
                int a = cost[0];
                int b = cost[1];
                int c = cost[2];

                if (find(a) != find(b)) {
                    union(a, b);
                    totalCost += c;
                    count++;

                    if (count == n - 1) {
                        break;
                    }
                }
            }

            return totalCost;
        }
    }
    public static void main(String[] args) {
        Problem4 prom = new Problem4();
        Solution sol = prom.new Solution();
        int n1 = 4;
        int[][] costs = {
                {1, 2, 1},
                {2, 3, 4},
                {1, 3, 3},
                {1, 4, 2},
                {4, 3, 5}
        };

        System.out.println(sol.solution(n1, costs)); // 출력: 7
    }

}

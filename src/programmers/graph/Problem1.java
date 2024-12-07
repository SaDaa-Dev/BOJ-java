package programmers.graph;

import java.util.*;

public class Problem1 {
    private class Solution {

        public int solution(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int from = edge[0] - 1;
                int to = edge[1] - 1;

                adj.get(from).add(to);
                adj.get(to).add(from);
            }

            int[] distance = bfs(adj, 0, n);

            OptionalInt maxDistance = Arrays.stream(distance).max();

            int cnt = 0;
            for (int dist : distance) {
                if (dist == maxDistance.getAsInt()) {
                    cnt++;
                }
            }

            return cnt;
        }

        private int[] bfs(List<List<Integer>> adj, int start, int n) {
            int[] distance = new int[n];
            Arrays.fill(distance, -1); // 초기 거리는 -1로 설정 (방문하지 않은 노드)
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            distance[start] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbor : adj.get(current)) {
                    if (distance[neighbor] == -1) { // 아직 방문하지 않은 노드
                        distance[neighbor] = distance[current] + 1;
                        queue.offer(neighbor);
                    }
                }
            }

            return distance;
        }

    }
    public static void main(String[] args) {
        Problem1 prom = new Problem1();
        Solution sol = prom.new Solution();

        int[][] vertex = new int[][]{
                {3,6},
                {4,3},
                {3,2},
                {1,3},
                {1,2},
                {2,4},
                {5,2}
        };
        int n = 6;

        System.out.println(sol.solution(n, vertex));
    }
}

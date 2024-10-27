package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BOJ2606_bfs {
    public class Solution {
        private ArrayList<ArrayList<Integer>> adj;
        private boolean[] visited;
        public int solution(ArrayList<ArrayList<Integer>> adj) {
            this.adj = adj;
            this.visited = new boolean[adj.size()];
            return bfs(0);
        }

        private int bfs(int start) {
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                Integer current = queue.poll();

                for (Integer neighbor : adj.get(current)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        BOJ2606_bfs boj = new BOJ2606_bfs();
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

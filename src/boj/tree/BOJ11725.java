package boj.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 백준 11725번, 트리의 부모 찾기
public class BOJ11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n + 1];

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 간접리스트로 무방향 간선 트리
        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

//        bfs(n, parent, adj, visited);
        dfs(1, 0, parent, adj);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int current, int p, int[] parent, List<List<Integer>> adj) {
        parent[current] = p; // 현재 노드의 부모 설정

        for (Integer neighbor : adj.get(current)) {
            if (neighbor != p) { // 부모 노드로 다시 가지 않도록 확인
                dfs(neighbor, current, parent, adj);
            }
        }
    }

    private static void bfs(int n, int[] parent, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int another : adj.get(current)) {
                if (visited[another]) {
                    continue;
                }

                visited[another] = true;
                queue.add(another);
                parent[another] = current;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}

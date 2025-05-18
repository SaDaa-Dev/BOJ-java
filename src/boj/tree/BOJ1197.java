package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1197 {
    private static class Edge implements Comparable<Edge> {
        private int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    private static int[] parent, rank;
    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());


        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {                     // ★ 간선 E줄
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges);

        parent = new int[v + 1];
        rank = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        long answer = 0;
        int picked = 0;

        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                answer += edge.w;
                if (++picked == v - 1) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

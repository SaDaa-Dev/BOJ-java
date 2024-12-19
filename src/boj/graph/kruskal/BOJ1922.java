package boj.graph.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 네트워크 연결
public class BOJ1922 {
    private int[] parent;
    public class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

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

    private int solution(int n, int m, List<List<Integer>> edges) {
        // 부모 배열 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Edge List 초기화
        List<Edge> edgesList = new ArrayList<>();
        for (List<Integer> edge : edges) {
            edgesList.add(new Edge(edge.get(0), edge.get(1), edge.get(2)));
        }
        Collections.sort(edgesList);

        int mstCost = 0;
        int count = 0;
        for (Edge edge : edgesList) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstCost += edge.w;
                count++;
            }

            if (count == n - 1) {
                break;
            }
        }


        return mstCost;
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private int find(int v) {
        if (parent[v] == v) {
            return v;
        } else {
            parent[v] = find(parent[v]);
            return parent[v];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정점 수
        int m = Integer.parseInt(br.readLine()); // 간선의 수

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edges.add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        BOJ1922 prom = new BOJ1922();
        System.out.println(prom.solution(n, m, edges));
    }
}

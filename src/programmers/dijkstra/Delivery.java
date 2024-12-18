package programmers.dijkstra;

import java.util.*;

public class Delivery {

    private class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private int solution(int N, int[][] road, int K) {
        // 간선 초기화
        List<List<Node>> edges = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
           edges.add(new ArrayList<>());
        }

        for (int[] r : road) { // 양방향 그래프
            edges.get(r[0]).add(new Node(r[1], r[2]));
            edges.get(r[1]).add(new Node(r[0], r[2]));
        }

        // 다익스트라로 정점별 거리 계산
        int[] dist = dijkstra(1, edges, N);

        // 결과 도출
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private int[] dijkstra(int start, List<List<Node>> edges, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int currV = curr.vertex;
            int currW = curr.weight;

            if (distance[currV] < currW) continue;

            for (Node next : edges.get(currV)) {
                int cost = distance[currV] + next.weight;
                if (cost < distance[next.vertex]) {
                    distance[next.vertex] = cost;
                    queue.offer(new Node(next.vertex, cost));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        Delivery prom = new Delivery();
        int result = prom.solution(5, road, 3);
        System.out.println(result);

    }
}

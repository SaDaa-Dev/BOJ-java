package programmers.level3.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReturnUnit {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int from = road[0] - 1;
            int to = road[1] - 1;

            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        int[] minDistances = bfs(edges, n, destination - 1);
        for (int i = 0; i < sources.length; i++) {
            answer[i] = minDistances[sources[i] - 1];
        }
        return answer;
    }

    private int[] bfs(List<List<Integer>> edges, int n, int destination) {
        int[] distances = new int[n];
        Arrays.fill(distances, -1);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(destination);
        distances[destination] = 0;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            for (Integer next : edges.get(curr)) {
                if (distances[next] == -1) {
                    distances[next] =  distances[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        ReturnUnit problem = new ReturnUnit();
        int[][] roads = {{1, 2},{1, 4},{2, 4},{2, 5},{4, 5}};
        int[] sources = {1, 3, 5};
        problem.solution(5, roads, sources, 5);
    }
}

package programmers.level2.prac;


import java.util.ArrayDeque;
import java.util.Queue;

// 숫자 변환하기
public class ConvertNumber {
    // X -> Y / +N, *2, *3
    // 입력이 100만까지 가능 : 최소 O(N)
    // BFS 최단경로
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        int MAX = 1_000_000;
        boolean[] visited = new boolean[MAX + 1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currVal = curr[0];
            int currStep = curr[1];

            int next = currVal * 3;
            if (next <= MAX) {
                if (next == y) {
                    return currStep + 1;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, currStep + 1});
                }
            }

            next = currVal * 2;
            if (next <= MAX) {
                if (next == y) {
                    return currStep + 1;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, currStep + 1});
                }
            }

            next = currVal + n;
            if (next <= MAX) {
                if (next == y) {
                    return currStep + 1;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, currStep + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConvertNumber problem = new ConvertNumber();
        System.out.println(problem.solution(2, 5, 4));
    }
}

package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ13549_01BFS {
    static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = pos[0];
        int k = pos[1];

        int[] time = new int[MAX];
        Arrays.fill(time, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        time[n] = 0;

        while (!deque.isEmpty()) {
            int idx = deque.pollFirst();

            if (idx == k) {
                break;
            }

            int next = idx * 2;
            if (next >= 0 && next < MAX && time[next] == -1) {
                time[next] = time[idx];
                deque.addFirst(next);
            }

            next = idx - 1;
            if (next >= 0 && next < MAX && time[next] == -1) {
                time[next] = time[idx] + 1;
                deque.addLast(next);
            }

            next = idx + 1;
            if (next >= 0 && next < MAX && time[next] == -1) {
                time[next] = time[idx] + 1;
                deque.addLast(next);
            }
        }

        System.out.println(time[k]);
    }

}

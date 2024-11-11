package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0];
        int k = inputs[1];
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int flag = 1;
        while (!queue.isEmpty()) {
            Integer target = queue.poll();
            if (flag == k) {
                results.add(target);
                flag = 0;
            } else {
                queue.offer(target);
            }
            flag++;
        }

        System.out.print("<");
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i));
            if (!(i == results.size() - 1)) {
                System.out.print(", ");
            }
        }
        System.out.print(">");

        br.close();
    }
}

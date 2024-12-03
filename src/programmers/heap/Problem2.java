package programmers.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2 {
    public static void main(String[] args) {
        int[][] data = {
                {0, 3},
                {1, 9},
                {2, 6}
        };

        int re = solution(data);
        System.out.println("re = " + re);
    }

    private static int solution(int[][] jobs) {
        int totalTime = 0;
        int currentTime = 0;
        int completedJobs = 0;

        PriorityQueue<int[]> waitQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int[] job : jobs) {
            waitQueue.add(job);
        }

        PriorityQueue<int[]> processQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        while (completedJobs < jobs.length) {
            while (!waitQueue.isEmpty() && waitQueue.peek()[0] <= currentTime) {
                processQueue.add(waitQueue.poll());
            }

            if (!processQueue.isEmpty()) {
                int[] job = processQueue.poll();
                currentTime += job[1];
                totalTime += currentTime - job[0];
                completedJobs++;
            } else {
                currentTime++;
            }
        }

        return totalTime / jobs.length;
    }
}

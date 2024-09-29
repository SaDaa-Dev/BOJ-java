package programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem3 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result = solution(operations);
        System.out.println("최댓값: " + result[0] + ", 최솟값: " + result[1]);
    }

    private static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최소 힙

        for (String input : operations) {
            String[] inputStr = input.split(" ");
            String command = inputStr[0];
            if (command.equals("D")) {
                int commandNum = Integer.parseInt(inputStr[1]);
                if (!minHeap.isEmpty()) {
                    if (commandNum > 0) {
                        // 최댓값 삭제
                        Integer maxN = maxHeap.poll();
                        minHeap.remove(maxN);
                    } else {
                        // 최솟값 삭제
                        Integer minN = minHeap.poll();
                        maxHeap.remove(minN);
                    }
                }
            } else if (command.equals("I")) {
                int num = Integer.parseInt(inputStr[1]);
                minHeap.add(num);
                maxHeap.add(num);
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}

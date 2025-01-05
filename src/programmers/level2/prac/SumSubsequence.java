package programmers.level2.prac;

import java.nio.channels.SelectableChannel;
import java.util.*;

public class SumSubsequence {
    public int solution(int[] elements) {
        int len = elements.length;
        HashSet<Integer> sums = new HashSet<>();
        for (int size = 1; size <= len; size++) {
            for (int i = 0; i <= len; i++) { // 5번
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += elements[j % len];
                }
                sums.add(sum);
            }
        }

        return sums.size();
    }
    public static void main(String[] args) {
        SumSubsequence prom = new SumSubsequence();
        System.out.println(prom.solution(new int[]{7, 9, 1, 1, 4}));
    }
}

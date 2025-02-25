package programmers.level2.prac;

import java.util.ArrayDeque;

public class CrossSteppingStone {

    public int solution(int[] stones, int k) {
       int answer = Integer.MAX_VALUE;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < stones.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < (i - k + 1)) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) { // 윈도우 형성
                int windowMax = stones[deque.peekFirst()];
                answer = Math.min(windowMax, answer);
            }
        }

        return answer;
    }

//    public int solution(int[] stones, int k) {
//        int answer = 0;
//        while (isJumpingPossible(stones, k)) {
//            int minValue = Arrays.stream(stones).filter(o -> o != 0).min().getAsInt();
//            for (int i = 0; i < stones.length; i++) {
//                stones[i] = stones[i] - minValue;
//                if (stones[i] <= 0) {
//                    stones[i] = 0;
//                }
//            }
//            answer += minValue;
//        }
//        return answer;
//    }
//
//    private boolean isJumpingPossible(int[] stones, int k) {
//        int zeroCnt = 0;
//        for (int i = 0; i < stones.length; i++) {
//            if (stones[i] == 0) {
//                zeroCnt++;
//            } else {
//                zeroCnt = 0;
//            }
//
//            if (zeroCnt >= k) {
//                return false;
//            }
//        }
//        return true;
//    } 이전 풀이 (시간 초과)

//    public int solution(int[] stones, int k) {
//        int answer = Integer.MAX_VALUE;
//        for (int i = 0; i < stones.length - (k - 1); i++) {
//            int maxValue = Integer.MIN_VALUE;
//            for (int j = i; j <= i + (k - 1); j++) {
//                if (maxValue < stones[j]) {
//                    maxValue = stones[j];
//                }
//            }
//
//            answer = Math.min(maxValue, answer);
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        CrossSteppingStone problem = new CrossSteppingStone();
        int[] input = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(problem.solution(input, 3));
    }
}

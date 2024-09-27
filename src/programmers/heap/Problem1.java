package programmers.heap;

import java.util.PriorityQueue;

public class Problem1 {
    public static void main(String[] args) {
        int[] data = {1,2,3,9,10,12};
        int re = solution(data, 7);
        System.out.println("re = " + re);
    }

    private static int solution(int[] scoville, int K) {
        int mixCnt = 0;
        PriorityQueue<Integer> dishes = new PriorityQueue<>();

        for (int sco : scoville) {
            dishes.add(sco);
        }

        while (!dishes.isEmpty()) {
            if (dishes.peek() >= K) {
                return mixCnt;
            }

            if (dishes.size() < 2) {
                return -1;
            }

            Integer firstDish = dishes.poll();
            Integer secondDish = dishes.poll();

            int mixDish = firstDish + (secondDish * 2);
            dishes.add(mixDish);
            mixCnt++;
        }

        return -1;
    }
}

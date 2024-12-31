package programmers.level2.prac;

import java.util.ArrayDeque;
import java.util.Arrays;

public class JumpAndTeleport {
//    public int solution(int n) {
//        int MAX = n * 2;
//        int[] energy = new int[MAX];
//        Arrays.fill(energy, -1);
//
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        deque.add(0);
//        energy[0] = 0;
//
//        while (!deque.isEmpty()) {
//            int idx = deque.poll();
//
//            if (idx == n) {
//                return energy[idx];
//            }
//
//            int next = idx * 2;
//            if (next < MAX && next > 0 && energy[next] == -1) {
//                energy[next] = energy[idx];
//                deque.addFirst(next);
//            }
//
//            next = idx + 1;
//            if (next < MAX && next > 0 && energy[next] == -1) {
//                energy[next] = energy[idx] + 1;
//                deque.addLast(next);
//            }
//        }
//
//        return 0;
//    }

    // 첫번째 풀이 -> 메모리 사용량 초과
    // => 거꾸로 생각하기 Solution ver.2
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 0) { // 짝수
                n = n / 2;
            } else {
                n -= 1;
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        JumpAndTeleport prom = new JumpAndTeleport();
        System.out.println(prom.solution(5));
    }
}

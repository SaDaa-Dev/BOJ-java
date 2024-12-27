package programmers.level2.prac;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeleteCoupleAlpha {

    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peek() == c) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        return deque.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        DeleteCoupleAlpha prom = new DeleteCoupleAlpha();
        System.out.println(prom.solution("cdcd"));
    }
}

package programmers.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Problem4 {
    public static void main(String[] args) {

    }

    private static int solution(int[] priorities, int location) {
        LinkedList<Integer> processes = new LinkedList<>();
        Iterator<Integer> iter = processes.iterator();

        while (processes.isEmpty()) {
            Integer first = processes.remove(0);
            if (processes.stream().anyMatch(a -> a.intValue() > first)) {

            }

        }

        return 0;
    }
}

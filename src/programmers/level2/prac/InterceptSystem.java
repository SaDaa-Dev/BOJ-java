package programmers.level2.prac;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptSystem {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int lastIntercept = -1;
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            if (s >= lastIntercept) {
                answer++;
                lastIntercept = e;
                System.out.println("answer = " + answer + "(" + s + ", " + e + ")" + " 방 !!");
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        InterceptSystem problem = new InterceptSystem();
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        problem.solution(targets);
    }
}

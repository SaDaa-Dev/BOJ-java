package programmers.level2.prac;

import java.util.Arrays;
import java.util.Collections;

public class MakeMin {
    public int solution(int[] A, int[] B) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[A.length - 1 - i];

            result += (a * b);
        }
        
        return result;
    }
    public static void main(String[] args) {
        MakeMin prom = new MakeMin();
        System.out.println(prom.solution(new int[]{1, 2}, new int[]{3, 4}));
    }
}

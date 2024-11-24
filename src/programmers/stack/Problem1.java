package programmers.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Problem1 {
    public static void main(String[] args) {
        int[] data = {4,4,4,3,3};


        int[] solution = solution(data);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    
    private static int[] solution(int[] arr){
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

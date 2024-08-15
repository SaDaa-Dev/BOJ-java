package programmers.stack;

import java.util.Stack;

public class problem1 {
    public static void main(String[] args) {
        int[] data = {4,4,4,3,3};

        int[] solution = solution(data);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    
    private static int[] solution(int[] arr){
        Stack<Integer> nums = new Stack<>();
        int beforeNum = arr[0];
        nums.push(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            if (!(beforeNum == arr[i])) {
                nums.push(arr[i]);
                beforeNum = arr[i];
            }
        }

        return nums.stream().mapToInt(i -> i).toArray();
    }
}

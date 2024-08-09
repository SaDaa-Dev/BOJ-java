package programmers.hash;

import java.util.HashSet;

public class problem1 {
    public static void main(String[] args) {

    }

    private static  int solution(int[] nums) {
        HashSet<Integer> uniqueNumbers = new HashSet<Integer>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        int maxUniqueSelections = nums.length / 2;
        return Math.min(maxUniqueSelections, uniqueNumbers.size());
    }
}

package programmers.level3.kakao;

import java.util.*;

public class ShoppingJewel {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int typeSize = set.size();
        int n = gems.length;
        Map<String, Integer> window = new HashMap<>();
        int right = 0, left = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < n) {
            window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
            right++;

            while (window.size() == typeSize) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }

                window.put(gems[left], window.get(gems[left]) - 1);
                if (window.get(gems[left]) == 0) {
                    window.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        ShoppingJewel problem = new ShoppingJewel();
        String[] input = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(problem.solution(input)));
    }
}

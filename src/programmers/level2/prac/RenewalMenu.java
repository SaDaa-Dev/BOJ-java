package programmers.level2.prac;

import java.util.*;

public class RenewalMenu {

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        ArrayList<String> combinations = new ArrayList<>();
        for (String order : orders) {
            makeCombination(order, combinations);
        }

        for (int courseLength : course) {
            Map<String, Integer> freqMap = new HashMap<>();
            // course 길이에 맞는 조합만 frequency map에 담기
            for (String comb : combinations) {
                if (comb.length() == courseLength) {
                    freqMap.put(comb, freqMap.getOrDefault(comb, 0) + 1);
                }
            }

            // 2회 이상 주문된 조합만 고려
            int maxCount = 0;
            for (int count : freqMap.values()) {
                if (count >= 2 && count > maxCount) {
                    maxCount = count;
                }
            }

            // 최대 빈도 수와 같은 조합을 정답에 추가
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private static void makeCombination(String order, ArrayList<String> combination) {
        char[] arr = order.toCharArray();
        Arrays.sort(arr);
        order = new String(arr);

        int n = order.length();
        int total = 1 << n;
        for (int i = 1; i < total; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(order.charAt(j));
                }
            }
            combination.add(sb.toString());
        }
    }

    public static void main(String[] args) {
        RenewalMenu problem = new RenewalMenu();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(problem.solution(orders, course)));
    }
}

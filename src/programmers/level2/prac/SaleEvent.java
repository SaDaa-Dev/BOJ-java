package programmers.level2.prac;

import java.util.*;

public class SaleEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int possibleDayCnt = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                discountMap.put(product, discountMap.getOrDefault(product, 0) + 1);
            }

            boolean isPossible = true;
            for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                String wantedProduct = entry.getKey();
                int wantedCount = entry.getValue();

                if (discountMap.getOrDefault(wantedProduct, 0) < wantedCount) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                possibleDayCnt++;
            }
        }

        return possibleDayCnt;
    }
    public static void main(String[] args) {
        SaleEvent prom = new SaleEvent();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(prom.solution(want, number, discount));
    }
}

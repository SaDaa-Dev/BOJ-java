package programmers.level2.prac;

import java.sql.Array;
import java.util.*;

public class EmotionsSale {
    private List<List<Integer>> comboSet = new ArrayList<>();
    private int emoticonsLen;
    private int[] discountRates = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        emoticonsLen = emoticons.length;

        // 할인율에 대한 모든 경우의 수 탐색
        makeCombo(new ArrayList<>());

        // 경우의 수에 대한 [플러스 가입자, 이모티콘 판매금액]
        int maxSubscriber = 0;
        int maxSale = 0;

        for (List<Integer> rates : comboSet) {
            // 가입자, 판매액
            int subscriberCnt = 0;
            int totalSalePrice = 0;

            for (int[] user : users) {
                int saleRate = user[0];
                int money = user[1];
                int buyPrice = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (rates.get(i) >= saleRate) { // 할인율에 따라 구매
                        int discountedPrice = emoticons[i] * (100 - rates.get(i)) / 100;
                        buyPrice += discountedPrice;
                    }
                }

                if (buyPrice >= money) { // 예산 초과 -> 구독
                    subscriberCnt++;
                } else { // 예산 내 -> 구매
                    totalSalePrice += buyPrice;
                }
            }

            if (subscriberCnt > maxSubscriber) {
                maxSubscriber = subscriberCnt;
                maxSale = totalSalePrice;
            } else if (subscriberCnt == maxSubscriber && totalSalePrice > maxSale) {
                maxSale = totalSalePrice;
            }
        }

        return new int[]{maxSubscriber, maxSale};
    }

    private void makeCombo(List<Integer> currentCombo) {
        if (currentCombo.size() == emoticonsLen) {
            comboSet.add(new ArrayList<>(currentCombo));
            return;
        }

        for (int discountRate : discountRates) {
            currentCombo.add(discountRate);
            makeCombo(currentCombo);
            currentCombo.remove(currentCombo.size() - 1);
        }
    }

    public static void main(String[] args) {
        // users -> [비율, 가진돈]
        // emoticons -> [정가]  /  할인율은 10, 20, 30, 40
        EmotionsSale emotionsSale = new EmotionsSale();
        int[][] users = {
                {40, 10000}, {25, 10000}
        };
        int[] emoticons = {7000, 9000};
        emotionsSale.solution(users, emoticons);
    }
}

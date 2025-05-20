package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11047 {
    private static int needMinCoinQuantity(int[] coins, int target) {
        int coinCnt = 0;

        coins = Arrays.stream(coins).boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        for (int coin : coins) {
            if (target == 0) break;

            if (target >= coin) {
                int num = target / coin;
                target -= coin * num;
                coinCnt += num;
            }
        }

        return coinCnt;
    }
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nk = new StringTokenizer(br.readLine());
            int coinCnt = Integer.parseInt(nk.nextToken());
            int targetPrice = Integer.parseInt(nk.nextToken());

            int[] coins = new int[coinCnt];
            for (int i = 0; i < coinCnt; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            System.out.println(needMinCoinQuantity(coins, targetPrice));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

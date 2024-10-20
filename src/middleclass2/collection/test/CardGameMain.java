package middleclass2.collection.test;

import poly.car0.Car;

import java.util.*;

public class CardGameMain {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player("김");
        Player player2 = new Player("정");

        for (int i = 0; i < 5; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        player1.showHand();
        player2.showHand();

        Player winner = getWinner(player1, player2);
        if (winner != null) {
            System.out.println(winner.getName() + " 승리");
        } else {
            System.out.println("무승부!");
        }

    }

    private static Player getWinner(Player player1, Player player2) {
        int sum1 = player1.sum();
        int sum2 = player2.sum();

        return sum1 > sum2 ? player1 : (sum1 == sum2) ? null : player2;
    }
}

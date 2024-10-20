package middleclass2.collection.test;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void drawCard(Deck deck) {
        hand.add(deck.drawCard());
    }

    public int sum() {
        int result = 0;
        for (Card card : hand) {
            result += card.getNumber();
        }

        return result;
    }



    public void showHand() {
        hand.sort(null);
        System.out.println(name + "의 카드" + hand + ", 합계 : " + sum());
    }

    public String getName() {
        return name;
    }
}

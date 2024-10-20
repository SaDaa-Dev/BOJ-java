package middleclass2.collection.test;

public class Card implements Comparable<Card> {
    private final int number;
    private final Suit icon;

    public Card(int number, Suit icon) {
        this.number = number;
        this.icon = icon;
    }

    public int getNumber() {
        return number;
    }

    public Suit getIcon() {
        return icon;
    }



    @Override
    public String toString() {
        return number + "(" + icon.getIcon() + ")";
    }

    @Override
    public int compareTo(Card anotherCard) {
        if (this.number != anotherCard.number) {
            return Integer.compare(this.number, anotherCard.number);
        } else {
            return this.icon.compareTo(anotherCard.icon);
        }
    }
}

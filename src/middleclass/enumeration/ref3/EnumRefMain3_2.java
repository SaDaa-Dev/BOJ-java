package middleclass.enumeration.ref3;

import static middleclass.enumeration.ref3.Grade.*;

public class EnumRefMain3_2 {
    public static void main(String[] args) {
        int price = 10000;

        System.out.println("basic = " + BASIC.discount(price));
        System.out.println("gold = " + GOLD.discount(price));
        System.out.println("diamond = " + DIAMOND.discount(price));
    }
}

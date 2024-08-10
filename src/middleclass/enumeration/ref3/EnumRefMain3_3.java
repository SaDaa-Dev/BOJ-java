package middleclass.enumeration.ref3;

import static middleclass.enumeration.ref3.Grade.*;

public class EnumRefMain3_3 {
    public static void main(String[] args) {
        int price = 10000;

        for (Grade grade : values()) {
            printDiscount(grade, price);
        }
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " 등급의 할인 금액 : " + grade.discount(price));
    }
}

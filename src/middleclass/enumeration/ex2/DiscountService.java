package middleclass.enumeration.ex2;

public class DiscountService {
    public int discount(ClassGrade classGrade, int price) {
        int discountPercent = 0;

        if (classGrade == classGrade.BASIC) {
            discountPercent = 10;
        } else if (classGrade == classGrade.GOLD) {
            discountPercent = 20;
        } else if (classGrade == classGrade.DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인 X");
        }

        return price * discountPercent / 100;
    }
}

package middleclass1.enumeration.ref1;

public class DiscountService {
    public int discount(ClassGrade grade, int price) {
        return price * grade.getDiscountPercent() / 100;
    }
}

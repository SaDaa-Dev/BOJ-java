package middleclass2.collection.list.test.ex2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> shoppingList;
    private int totalPrice;

    public ShoppingCart() {
        this.shoppingList = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addItem(Item item) {
        shoppingList.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < shoppingList.size(); i++) {
            totalPrice += shoppingList.get(i).getTotalPrice();
            System.out.println("상품명 : " + shoppingList.get(i).getName() + ", 합계 : " + shoppingList.get(i).getTotalPrice());
        }
        System.out.println("전체 가격 합 : " + totalPrice);
    }
}

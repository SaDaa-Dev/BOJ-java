package middleclass2.collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product product, Integer quantity) {
        cartMap.put(product, cartMap.getOrDefault(product, 0) + quantity);
    }

    public void minus(Product product, Integer quantity) {
        Integer oldQuantity = cartMap.getOrDefault(product, 0);
        int newQuantity = oldQuantity - quantity;
        if (newQuantity <= 0) {
            cartMap.remove(product);
        } else {
            cartMap.put(product, newQuantity);
        }
    }

    public void printAll() {
        System.out.println("====모든 상품 출력====");
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " 수량 : " + entry.getValue());
        }
    }

}

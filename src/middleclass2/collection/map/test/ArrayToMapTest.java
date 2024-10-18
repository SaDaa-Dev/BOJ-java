package middleclass2.collection.map.test;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {
                {"java", "10000"},
                {"Spring", "20000"},
                {"JPA", "30000"},
        };
        
        Map<String, Integer> map = new HashMap<>();
        for (String[] datas : productArr) {
            map.put(datas[0], Integer.valueOf(datas[1]));
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("제품 : " + entry.getKey() + ", 가격 : " + entry.getValue());
        }
    }
}

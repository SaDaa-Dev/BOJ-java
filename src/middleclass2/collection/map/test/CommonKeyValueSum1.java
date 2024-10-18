package middleclass2.collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class CommonKeyValueSum1 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("B", 4);
        map2.put("C", 5);
        map2.put("D", 6);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
                Integer originValue = map1.get(entry.getKey());
                Integer targetValue = entry.getValue();

                map1.put(entry.getKey(), originValue + targetValue);
            } else {
                map1.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("map1 = " + map1);

    }
}

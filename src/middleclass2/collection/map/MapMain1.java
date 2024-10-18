package middleclass2.collection.map;

import java.util.ArrayDeque;
import java.util.HashMap;

public class MapMain1 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();
        studentMap.put("studentA", 90);

        studentMap.putIfAbsent("studentA", 100);

        System.out.println("studentMap = " + studentMap);

    }
}

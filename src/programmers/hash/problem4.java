package programmers.hash;

import java.util.HashMap;

public class problem4 {
    public static void main(String[] args) {
        String[][] data = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(data);

        System.out.println("result = " + result);
    }

    private static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] item : clothes) {
            String type = item[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int result = 1;

        for (int count : map.values()) {
            result *= (count + 1);
        }

        return result - 1;
    }
}

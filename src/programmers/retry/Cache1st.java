package programmers.retry;

import java.util.LinkedList;

public class Cache1st {
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        LinkedList<String> cache = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String c = city.toUpperCase();
            if (cache.contains(c)) {
                cache.remove(c);
                cache.add(c);
                totalTime += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(c);
                totalTime += 5;
            }
        }

        return totalTime;
    }
    public static void main(String[] args) {
        Cache1st prom = new Cache1st();
        String[] input = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(prom.solution(3, input));
    }
}

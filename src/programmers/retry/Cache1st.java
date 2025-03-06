package programmers.retry;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache1st {

    private class LRUHashMap extends LinkedHashMap<String, Boolean> {
        private final int capacity;

        public LRUHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
            return size() > capacity;
        }
    }

    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        LRUHashMap lruHashMap = new LRUHashMap(cacheSize);

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String c = city.toUpperCase();
            if (lruHashMap.containsKey(c)) {
                lruHashMap.get(c);
                totalTime += 1;
            } else {
                lruHashMap.put(c, true);
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

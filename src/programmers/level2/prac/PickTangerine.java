package programmers.level2.prac;

import java.util.*;

public class PickTangerine {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int answer = 0;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            cnt += entry.getValue();
            answer++;
            if (cnt >= k) {
                return answer;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        PickTangerine prom = new PickTangerine();

        System.out.println(prom.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}

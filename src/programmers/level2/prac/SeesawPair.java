package programmers.level2.prac;

import java.util.Arrays;
import java.util.HashMap;

public class SeesawPair {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();

        for (int w : weights) {
            double a = w;
            double b = (double) w * 2.0 / 3;
            double c = (double) w * 3.0 / 4;
            double d = (double) w / 2;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        SeesawPair s = new SeesawPair();
        int[] input = {100, 180, 360, 100, 270};
        System.out.println(s.solution(input)); // 예시 출력
    }
}
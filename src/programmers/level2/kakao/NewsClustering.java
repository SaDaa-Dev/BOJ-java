package programmers.level2.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsClustering {

    public int solution(String str1, String str2) {
        // 두 문자열을 다중집합으로 변환
        List<String> set1 = convertTwoComb(str1);
        List<String> set2 = convertTwoComb(str2);

        // 교집합과 합집합 계산
        int intersection = calculateIntersection(set1, set2);
        int union = calculateUnion(set1, set2);

        // 자카드 유사도 계산
        if (union == 0) {
            return 65536; // 합집합이 0인 경우 유사도 1로 처리
        }
        return (int) Math.floor(((double) intersection / union) * 65536);
    }

    private List<String> convertTwoComb(String str) {
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);

            // 두 글자가 모두 알파벳인 경우만 추가
            if (Character.isLetter(first) && Character.isLetter(second)) {
                list.add("" + first + second);
            }
        }

        return list;
    }

    private int calculateIntersection(List<String> set1, List<String> set2) {
        Map<String, Integer> countMap1 = getCountMap(set1);
        Map<String, Integer> countMap2 = getCountMap(set2);

        int intersection = 0;
        for (String key : countMap1.keySet()) {
            if (countMap2.containsKey(key)) {
                intersection += Math.min(countMap1.get(key), countMap2.get(key));
            }
        }
        return intersection;
    }

    private int calculateUnion(List<String> set1, List<String> set2) {
        Map<String, Integer> countMap1 = getCountMap(set1);
        Map<String, Integer> countMap2 = getCountMap(set2);

        int union = 0;
        for (String key : countMap1.keySet()) {
            if (countMap2.containsKey(key)) {
                union += Math.max(countMap1.get(key), countMap2.get(key));
            } else {
                union += countMap1.get(key);
            }
        }
        for (String key : countMap2.keySet()) {
            if (!countMap1.containsKey(key)) {
                union += countMap2.get(key);
            }
        }
        return union;
    }

    private Map<String, Integer> getCountMap(List<String> set) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : set) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        return countMap;
    }

    public static void main(String[] args) {
        NewsClustering prom = new NewsClustering();
        System.out.println(prom.solution("FRANCE", "french")); // 결과: 16384
        System.out.println(prom.solution("handshake", "shake hands")); // 결과: 65536
        System.out.println(prom.solution("aa1+aa2", "AAAA12")); // 결과: 43690
        System.out.println(prom.solution("E=M*C^2", "e=m*c^2")); // 결과: 65536
    }
}
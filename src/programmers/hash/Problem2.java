package programmers.hash;

import java.util.HashMap;

public class Problem2 {
    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden"};
        String[] comple = {"eden", "kiki"};

        String result = solution(part, comple);

        System.out.println("result = " + result);
    }

    // HashMap으로 개선
    private static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1   );
        }

        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }

        for (String str : map.keySet()) {
            if (map.get(str) != 0) {
                return str;
            }
        }

        return "";
    }


    // 문자 이중배열을 비교할 때, 이중 for문으로 처리하는 것은 시간복잡도에서 매우 불리함.
    private static String faultSolution(String[] participant,String[] completion) {
        int flag = 0;
        int idx = 0;
        for (int i = 0; i < participant.length; i++) {
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) {
                    flag++;
                }
            }
            if (flag == 0) {
                idx = i;
                break;
            } else {
                flag = 0;
            }
        }

        return participant[idx];
    }
}

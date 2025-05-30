package programmers.level2.kakao;

import java.util.*;

public class Compression {
    /*
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        int dictionaryIdx = 26;
        HashMap<Integer, String> dictionary = firstDictionary(); // 사전 초기화 65 ~ 97 Index => 1 ~ 26
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = msg.length() - 1; i >= 0; i--) {
            stack.push(String.valueOf(msg.charAt(i)));
        }

        while (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String currentC = stack.pop();
            sb.append(currentC);

            while (!stack.isEmpty() && dictionary.containsValue(sb + stack.peek())) {
                String nextC = stack.pop();
                sb.append(nextC);
            }

            // sb에 대한 코드 result에 추가
            System.out.println(sb);
            for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(sb.toString())) {
                    result.add(entry.getKey());
                }
            }

            // 새로운 Dictionary 단어 등록
            if (!stack.isEmpty()) {
                dictionary.put(++dictionaryIdx, sb + stack.peek());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private HashMap<Integer, String> firstDictionary() {
        HashMap<Integer, String> dictionary = new HashMap<>();
        for (int i = 65; i < 91; i++) {
            dictionary.put(i - 64, Character.toString(i));
        }
        return dictionary;
    }
*/

    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int addIdx = 27;
        String prefix = "";
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (dictionary.containsKey(prefix + c)) { // 계속 붙여감
                prefix += c;
            } else {
                result.add(dictionary.get(prefix));
                dictionary.put(prefix, addIdx++);
                prefix = String.valueOf(c);
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Compression problem = new Compression();
        System.out.println(Arrays.toString(problem.solution("KAKAO")));
    }
}

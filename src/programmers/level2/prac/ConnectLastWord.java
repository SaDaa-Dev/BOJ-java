package programmers.level2.prac;

import java.util.Arrays;
import java.util.HashSet;

public class ConnectLastWord {
    // HashSet Add O(1)
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        char lastLetter = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (lastLetter != words[i].charAt(0)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            int beforeSetSize = set.size();
            set.add(words[i]);
            lastLetter = words[i].charAt(words[i].length() - 1);
            int afterSetSize = set.size();


            if (beforeSetSize == afterSetSize) {
                // 중복 단어 말함
                return new int[]{i % n + 1, i / n + 1};
            }
        }

        return new int[]{0, 0};
    }
    public static void main(String[] args) {
        ConnectLastWord prom = new ConnectLastWord();
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(prom.solution(2, words)));
    }
}

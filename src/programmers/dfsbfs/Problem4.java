package programmers.dfsbfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem4 {
    private class Solution {
        private boolean[] visited;
        public int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];
            Queue<WordInfo> deque = new ArrayDeque<>();
            deque.offer(new WordInfo(begin, 0));

            while (!deque.isEmpty()) {
                WordInfo current = deque.poll();
                String currentWord = current.word;
                int currentChangeCount = current.changeCount;

                if (currentWord.equals(target)) {
                    return currentChangeCount;
                }

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && isOneDiffLetter(currentWord, words[i])) {
                        visited[i] = true;
                        deque.offer(new WordInfo(words[i], currentChangeCount + 1));
                    }
                }

            }

            return 0;
        }

        private boolean isOneDiffLetter(String word1, String word2) {
          int diff = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                }
            }
          return diff == 1;
        }

        private class WordInfo {
            String word;
            int changeCount;

            public WordInfo(String word, int changeCount) {
                this.word = word;
                this.changeCount = changeCount;
            }
        }
    }

    public static void main(String[] args) {
        Problem4 prom = new Problem4();
        Solution sol = prom.new Solution();

        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(sol.solution(begin1, target1, words1));

    }
}

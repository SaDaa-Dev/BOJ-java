package programmers.dynamic;

public class Problem2 {
    private class Sol {
        public int solution(String name) {
            int answer = 0;
            int length = name.length();
            int minMove = length - 1;

            for (int i = 0; i < length; i++) {
                char current = name.charAt(i);
                int changeCnt = Math.min(current - 'A', 'Z' - current + 1);
                answer += changeCnt;

                int next = i + 1;
                while (next < length && name.charAt(next) == 'A') {
                    next++;
                }

                minMove = Math.min(minMove, i * 2 + (length - next));
                minMove = Math.min(minMove, i + 2 * (length - next));
            }

            answer += minMove;
            return answer;
        }
    }
    public static void main(String[] args) {
        Problem2 prom = new Problem2();
        Sol sol = prom.new Sol();

        System.out.println(sol.solution("JEROEN"));
    }
}

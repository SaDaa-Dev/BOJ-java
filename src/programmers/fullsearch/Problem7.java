package programmers.fullsearch;

public class Problem7 {
    private static final char[] preset = {'A', 'E', 'I', 'O', 'U'};
    private String targetStr;
    private int cnt;
    private boolean found;

    public int solution(String word) {
        this.targetStr = word;
        this.cnt = 0;
        this.found = false;

        backtrack("");

        return cnt;
    }

    private void backtrack(String current) {
        if (found) return;

        if (current.length() > 0) {
            cnt++;
            if (current.equals(targetStr)) {
                found = true;
                return;
            }
        }

        if (current.length() == preset.length) {
            return;
        }

        for (char initial : preset) {
            backtrack(current + initial);
            if(found) return;
        }
    }

    public static void main(String[] args) {
        Problem7 sol = new Problem7();
        String input = "AAAAE";
        int cnt = sol.solution(input);
        System.out.println("cnt = " + cnt);
    }
}

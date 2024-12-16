package programmers.level2.prac;

public class NQueen {
    private int answer;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    public int solution(int n) {
        cols = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];

        answer = 0;

        backtrack(0, n);

        return answer;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row + col] && !diag2[(row - col) + (n - 1)]) {
                cols[col] = true;
                diag1[row + col] = true;
                diag2[(row - col) + (n - 1)] =  true;

                backtrack(row + 1, n);

                diag1[row + col] = false;
                diag2[(row - col) + (n - 1)] =  false;
                cols[col] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        System.out.println(nQueen.solution(4));
    }
}

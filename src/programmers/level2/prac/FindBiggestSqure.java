package programmers.level2.prac;

public class FindBiggestSqure {
    public int solution(int[][] board) {
        int answer = 0;
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            dp[0][i] = board[0][i];
            answer = Math.max(answer, dp[0][i]);
        }
        for (int i = 0; i < rows; i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(answer, dp[i][0]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        FindBiggestSqure problem = new FindBiggestSqure();
        int[][] input = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(problem.solution(input));
    }
}

package programmers.level2.prac;

public class RotateProcession {
    private int[][] DIRECTION = {
            {0, 1}, // 우
            {1, 0}, // 하
            {0, -1}, // 좌
            {-1, 0} // 상
    };
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = makeBoard(rows, columns);
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1; // 0-Index 기반 변경
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = rotate(board, x1, y1, x2, y2);
        }

        return answer;
    }

    private int rotate(int[][] board, int x1, int y1, int x2, int y2) {
        int tmp = board[x1][y1];
        int minValue = tmp;
        int x = x1, y = y1;

        for (int i = 0; i < DIRECTION.length; i++) {
            while (true) {
                int nx = x + DIRECTION[i][0];
                int ny = y + DIRECTION[i][1];

                if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                    break;
                }

                // 값 변경
                int v = board[nx][ny];
                board[nx][ny] = tmp;
                tmp = v;

                if (tmp < minValue) {
                    minValue = tmp;
                }

                x = nx;
                y = ny;
            }
        }

        return minValue;
    }

    private int[][] makeBoard(int rows, int columns) {
        int[][] board = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = value++;
            }
        }
        return board;
    }

    public static void main(String[] args) {
        RotateProcession problem = new RotateProcession();
        int[][] inputs = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        problem.solution(6, 6, inputs);
    }
}

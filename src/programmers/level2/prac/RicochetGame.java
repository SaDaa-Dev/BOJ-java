package programmers.level2.prac;

import java.util.ArrayDeque;

public class RicochetGame {
    private int[] startPos = new int[2];
    private final int[][] DIRECTION = { // 상, 하, 좌, 우
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };
    public int solution(String[] board) {
        int row = board.length;
        int col = board[0].length();

        String[][] tBoard = transBoard(board, row, col);
        boolean[][] visited = new boolean[row][col];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startPos[0], startPos[1], 0});
        visited[startPos[0]][startPos[1]] = true;

        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int x = currPos[0];
            int y = currPos[1];
            int cnt = currPos[2];

            if (tBoard[x][y].equals("G")) {
                return cnt;
            }

            for (int[] dir : DIRECTION) {
                int nx = x;
                int ny = y;

                while (true) {
                    int nX = nx + dir[0];
                    int nY = ny + dir[1];

                    if(!(nX >= 0 && nX < row && nY >= 0 && nY < col) || tBoard[nX][nY].equals("D")) break;

                    nx = nX;
                    ny = nY;
                }

                if (!visited[nx][ny]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }

    private String[][] transBoard(String[] board, int row, int col) {
        String[][] tBoard = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] splitRow = board[i].split("");
            for (int j = 0; j < col; j++) {
                tBoard[i][j] = splitRow[j];
                if (tBoard[i][j].equals("R")) {
                    startPos[0] = i;
                    startPos[1] = j;
                }
            }
        }

        return tBoard;
    }

    public static void main(String[] args) {
        RicochetGame problem = new RicochetGame();
        String[] input = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println("problem.solution(input) = " + problem.solution(input));
    }
}

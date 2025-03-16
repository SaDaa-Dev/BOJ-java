package programmers.level2.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class CheckDistance {
    private final int[][] DIRECTION = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = checkRoom(places[i]);
        }

        return answer;
    }

    private int checkRoom(String[] room) {
        char[][] board = new char[5][5];
        for (int i = 0; i < room.length; i++) {
            board[i] = room[i].toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 'P') {
                    if (!bfs(board, i, j)) {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    private boolean bfs(char[][] board, int oX, int oY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[]{oX, oY, 0});
        visited[oX][oY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int distance = curr[2];

            if (distance >= 2) {
                continue;
            }

            for (int[] dir : DIRECTION) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                if (board[nx][ny] == 'P') {
                    return false;
                } else if (board[nx][ny] == 'O') {
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckDistance problem = new CheckDistance();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        problem.solution(places);
    }
}
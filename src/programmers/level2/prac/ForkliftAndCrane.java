package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ForkliftAndCrane {
    private class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private int rowLen, colLen;
    private boolean[][] accessible;
    public int solution(String[] storage, String[] requests) {
        rowLen = storage.length;
        colLen = storage[0].length();

        char[][] map = new char[rowLen + 2][colLen + 2];
        accessible = new boolean[rowLen + 2][colLen + 2];

        Arrays.stream(map).forEach(m -> Arrays.fill(m, '.'));

        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                map[r + 1][c + 1] = storage[r].charAt(c);
            }
        }

        updateAccessible(map);

        int removeCnt = 0;
        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() == 1) { // 지게차
                removeCnt += pickByForkLift(map, target);
            } else { // 크레인
                removeCnt += pickByCrane(map, target);
            }
            updateAccessible(map);
//            Arrays.stream(map).map(String::new).forEach(System.out::println);
//            Arrays.stream(accessible).map(Arrays::toString).forEach(System.out::println);
//            System.out.println();
        }

        return rowLen * colLen - removeCnt;
    }

    private void updateAccessible(char[][] map) {
        for (boolean[] row : accessible) {
            Arrays.fill(row, false);
        }

        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if ((i == 0 || i == map.length - 1 || j == 0 || j == map[0].length - 1) && map[i][j] == '.') {
                    q.offer(new Pos(i, j));
                    accessible[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pos curr = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curr.x + dx[dir];
                int ny = curr.y + dy[dir];

                if (nx < 0 || ny < 0 || nx > map.length - 1 || ny > map[0].length - 1 || accessible[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == '.') {
                    accessible[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                }
            }
        }

    }

    private int pickByForkLift(char[][] map, char target) {
        ArrayList<Pos> candidates = new ArrayList<>();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == target && isAccessible(row, col)) {
                    candidates.add(new Pos(row, col));
                }
            }
        }

        if (!candidates.isEmpty()) {
            for (Pos candidate : candidates) {
                map[candidate.x][candidate.y] = '.';
            }
        }

        return candidates.size();
    }

    private boolean isAccessible(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (accessible[nx][ny]) {
                return true;
            }
        }
        return false;
    }

    private int pickByCrane(char[][] map, char target) {
        int count = 0;
        for (int r = 0; r < rowLen + 2; r++) {
            for (int c = 0; c < colLen + 2; c++) {
                if (map[r][c] == target) {
                    map[r][c] = '.';
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        ForkliftAndCrane problem = new ForkliftAndCrane();
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};
        System.out.println(problem.solution(storage, requests));
    }
}

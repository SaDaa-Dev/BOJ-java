package programmers.level2.prac;

import java.util.*;

public class OilDrilling {
    private int rowLen;
    private int colLen;

    public int solution(int[][] land) {
        int maxOil = 0;
        rowLen = land.length;
        colLen = land[0].length;
        int[][] group = new int[rowLen][colLen];

        Map<Integer, Integer> groupSize = new HashMap<>();
        int groupNum = 1;
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (land[r][c] == 1 && group[r][c] == 0) {
                    int quantity = bfs(land, group, r, c, groupNum);
                    groupSize.put(groupNum, quantity);
                    groupNum++;
                }
            }
        }

        for (int col = 0; col < colLen; col++) {
            Set<Integer> groups = new HashSet<>();
            int oilSum = 0;
            for (int row = 0; row < rowLen; row++) {
                if (group[row][col] > 0 && groups.add(group[row][col])) {
                    oilSum += groupSize.get(group[row][col]);
                }
            }

            maxOil = Math.max(maxOil, oilSum);
        }

        return maxOil;
    }

    private int bfs(int[][] land, int[][] group, int r, int c, int groupNum) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int oilQuantity = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        group[r][c] = groupNum;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curr[0] + dx[dir];
                int ny = curr[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx > rowLen - 1 || ny > colLen - 1) {
                    continue;
                }

                if (land[nx][ny] == 1 && group[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    group[nx][ny] = groupNum;
                    oilQuantity++;
                }
            }
        }

        return oilQuantity;
    }


    // 시간 초과
//    public int solution(int[][] land) {
//        int oilMax = Integer.MIN_VALUE;
//        int row = land.length;
//        int col = land[0].length;
//        for (int c = 0; c < col; c++) {
//            boolean[][] visited = new boolean[row][col];
//
//            int oilQuantity = 0;
//            for (int r = 0; r < row; r++) {
//                if (!visited[r][c] && land[r][c] == 1) {
//                    oilQuantity += bfs(land, visited, r, c);
//                }
//            }
//
//            if (oilMax < oilQuantity) {
//                oilMax = oilQuantity;
//            }
//        }
//
//        return oilMax;
//    }
//
//    private int bfs(int[][] land, boolean[][] visited, int r, int c) {
//        int[] dx = {1, -1, 0, 0};
//        int[] dy = {0, 0, 1, -1};
//
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{r, c});
//        visited[r][c] = true;
//        int oilQuantity = 1;
//
//        while (!q.isEmpty()) {
//            int[] curr = q.poll();
//
//            for (int dir = 0; dir < 4; dir++) {
//                int nx = curr[0] + dx[dir];
//                int ny = curr[1] + dy[dir];
//
//                if (nx < 0 || ny < 0 || nx > land.length - 1 || ny > land[0].length - 1 || visited[nx][ny] || land[nx][ny] == 0) {
//                    continue;
//                }
//
//                if (!visited[nx][ny] && land[nx][ny] == 1) {
//                    q.offer(new int[]{nx, ny});
//                    visited[nx][ny] = true;
//                    oilQuantity++;
//                }
//            }
//        }
//
//        return oilQuantity;
//    }

    public static void main(String[] args) {
        OilDrilling problem = new OilDrilling();
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        System.out.println(problem.solution(land));
    }
}

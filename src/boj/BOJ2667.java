package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BOJ2667 {
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    public List<Integer> calcIsland(List<String> input) {
        int r = input.size();
        int c = input.get(0).length();

        int[][] board = new int[r][c];
        for (int i = 0; i < input.size(); i++) {
            int[] parsedStr = Arrays.stream(input.get(i).split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = parsedStr;
        }

        boolean[][] visited = new boolean[r][c];
        ArrayList<Integer> islands = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 0 && !visited[i][j]){
                    int islandSize = dfs(board, visited, i, j, 0);
                    islands.add(islandSize);
                }
            }
        }

        System.out.println(islands.size());
        islands.sort(Comparator.comparingInt(o -> o));
        for (Integer island : islands) {
            System.out.println(island);
        }

        return null;
    }

    private int dfs(int[][] board, boolean[][] visited, int r, int c, int currentSum) {
        int lr = board.length;
        int lc = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = dy[i] + r;
            int nc = dx[i] + c;

            if (nr < 0 || nc < 0 || nr > lr - 1 || nc > lc - 1) continue;
            if (board[nr][nc] == 0 || visited[nr][nc]) continue;

            visited[nr][nc] = true;

            currentSum = dfs(board, visited, nr, nc, currentSum + 1);
        }

        return currentSum;
    }

    public static void main(String[] args) throws IOException{
        BOJ2667 problem = new BOJ2667();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            List<String> input = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                input.add(str);
            }

            problem.calcIsland(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

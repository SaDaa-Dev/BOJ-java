package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[100][100];
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] pos = br.readLine().split(" ");
            int x = Integer.parseInt(pos[0]) - 1;
            int y = Integer.parseInt(pos[1]) - 1;

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    board[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(board[i][j] == 1){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}

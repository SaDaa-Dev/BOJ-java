package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int row = Integer.parseInt(nm[0]);
        int col = Integer.parseInt(nm[1]);

        int[][] board1 = new int[row][col];

        for (int i = 0; i < row * 2; i++) {
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            if(i < row){
                for (int j = 0; j < col; j++) {
                    board1[i][j] = target[j];
                }
            }else{
                for (int j = 0; j < col; j++) {
                    board1[i - row][j] += target[j];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board1[i][j] + " ");
            }
            System.out.println();
        }
    }
}

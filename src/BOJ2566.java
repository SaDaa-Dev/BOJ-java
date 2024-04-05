import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];
        int posX = 1;
        int posY = 1;
        int greaterNum = 0;
        for (int i = 0; i < 9; i++) {
            int[] rowData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < rowData.length; j++) {
                board[i][j] = rowData[j];

                if (board[i][j] > greaterNum) {
                    greaterNum = board[i][j];
                    posX = i + 1;
                    posY = j + 1;
                }
            }
        }

        System.out.println(greaterNum);
        System.out.println(posX + " " + posY);
    }
}

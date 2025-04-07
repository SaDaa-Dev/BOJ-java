package programmers.level2.prac;

public class AloneTictactoe {

    public int solution(String[] board) {
        int oCnt = 0, xCnt = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if(c == 'O') oCnt++;
                else if(c == 'X') xCnt++;
            }
        }

        if(xCnt > oCnt) return 0;
        if(oCnt > xCnt + 1) return 0;
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        if(oWin && xWin) return 0;
        if(oWin && oCnt != xCnt + 1) return 0;
        if(xWin && xCnt != oCnt) return 0;

        return 1;
    }

    private boolean isWin(String[] board, char player) {
        // 3행
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player &&
                    board[i].charAt(1) == player &&
                    board[i].charAt(2) == player) {
                return true;
            }
        }

        // 3열
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player &&
                    board[1].charAt(j) == player &&
                    board[2].charAt(j) == player) {
                return true;
            }
        }

        // 2대각
        // 좌상→우하
        if (board[0].charAt(0) == player &&
                board[1].charAt(1) == player &&
                board[2].charAt(2) == player) {
            return true;
        }
        // 우상→좌하
        if (board[0].charAt(2) == player &&
                board[1].charAt(1) == player &&
                board[2].charAt(0) == player) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        AloneTictactoe problem = new AloneTictactoe();
        problem.solution(new String[]{"O.X", ".O.", "..X"});
    }
}

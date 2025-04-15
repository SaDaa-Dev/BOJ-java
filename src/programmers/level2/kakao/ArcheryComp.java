package programmers.level2.kakao;

import java.util.Arrays;

public class ArcheryComp {
    private int[] apeach;
    private int[] bestBoard;
    private int bestDiff;
    private int N;
    public int[] solution(int n, int[] info) {
        this.N = n;
        this.apeach = info;
        this.bestBoard = new int[]{-1};
        dfs(0, new int[11], 0, 0);
        return bestBoard;
    }

    private void dfs(int idx, int[] ryanBoard, int ryanScore, int apeachScore) {
        if (idx == 11) {
            int used = Arrays.stream(ryanBoard).sum();
            if (used > N) return;

            ryanBoard[10] += (N - used);
            int diff = ryanScore - apeachScore;
            if (diff > bestDiff) {
                bestDiff  = diff;
                bestBoard = ryanBoard.clone();
            } else if (diff == bestDiff &&
                    diff > 0 &&
                    isPreferable(ryanBoard, bestBoard)) {
                bestBoard = ryanBoard.clone();
            }
            ryanBoard[10] -= (N - used);
            return;
        }

        int currScore = 10 - idx;
        int arrowCntForWin = apeach[idx] + 1;

        // 이기는 경우
        if (arrowCntForWin <= N) {
            ryanBoard[idx] = arrowCntForWin;
            dfs(idx + 1, ryanBoard, ryanScore + currScore, apeachScore);
            ryanBoard[idx] = 0;
        }

        // 지는 경우
        int apeachWinScore = apeach[idx] > 0 ? currScore : 0;
        dfs(idx + 1, ryanBoard, ryanScore, apeachScore + apeachWinScore);
    }

    private boolean isPreferable(int[] curr, int[] best) {
        if (best == null || best.length == 0) {
            return true;
        }

        for (int i = 10; i >= 0; i--) {
            if (curr[i] != best[i]) {
                return curr[i] > best[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArcheryComp problem = new ArcheryComp();
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(problem.solution(5, info)));
    }
}

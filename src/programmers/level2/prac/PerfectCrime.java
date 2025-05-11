package programmers.level2.prac;

public class PerfectCrime {

    public int solution(int[][] info, int n, int m) {

        boolean[][] cur = new boolean[n][m];   // 현재 단계 테이블
        cur[0][0] = true;

        for (int[] box : info) {
            int addA = box[0], addB = box[1];

            boolean[][] next = new boolean[n][m];     // 다음 단계 테이블

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!cur[a][b]) continue;

                    /* ① 이번 금고를 A가 털 때 */
                    int na = a + addA;
                    if (na < n) next[na][b] = true;

                    /* ② B가 털 때 */
                    int nb = b + addB;
                    if (nb < m) next[a][nb] = true;
                }
            }
            cur = next;    // 갱신 완료 → 다음 금고로
        }

        /* 최소 aSum 찾기 */
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (cur[a][b]) return a;
            }
        }
        return -1;        // 불가능
    }

    // dfs ( 시간 초과 )
//    private int minValue = Integer.MAX_VALUE;
//    private int n, m;
//    public int solution(int[][] info, int n, int m) {
//        this.n = n;
//        this.m = m;
//
//        int aSum = 0, bSum = 0;
//        dfs(info, 0, aSum, bSum);
//        return minValue != Integer.MAX_VALUE ? minValue : -1;
//    }
//
//    private void dfs(int[][] info, int idx, int aSum, int bSum) {
//        if (idx == info.length) {
//            if (aSum < n && bSum < m) {
//                minValue = Math.min(minValue, aSum);
//            }
//            return;
//        }
//
//        if (aSum > n || bSum > m) {
//            return;
//        }
//        // A가 훔쳤을 때
//        int aEvidence = info[idx][0];
//        dfs(info, idx + 1, aSum + aEvidence, bSum);
//        // B가 훔쳤을 때
//        int bEvidence = info[idx][1];
//        dfs(info, idx + 1, aSum, bSum + bEvidence);
//    }

    public static void main(String[] args) {
        PerfectCrime problem = new PerfectCrime();
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        System.out.println(problem.solution(info, 1, 7));
    }
}

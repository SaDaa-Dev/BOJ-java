package programmers.fullsearch;
public class Problem5 {
    private static int maxDungeonCnt = 0;
    public static void main(String[] args) {
        int[][] data = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        int k = 80;

        System.out.println(solution(k, data));
    }

    private static int solution(int  k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        return maxDungeonCnt;
    }

    private static void dfs(int[][] dungeons, boolean[] visited, int k, int cnt) {
        maxDungeonCnt = Math.max(maxDungeonCnt, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}

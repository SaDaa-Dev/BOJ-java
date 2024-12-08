package programmers.graph;

public class Problem2 {
    private class Solution {
        public int solution(int n, int[][] results) {
            int[][] graph = new int[n][n];

            // 인접 리스트 초기화
            for (int[] edge : results) {
                int winner = edge[0] - 1;
                int loser = edge[1] - 1;
                graph[winner][loser] = 1;
                graph[loser][winner] = -1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (graph[j][i] == 1 && graph[i][k] == 1) {
                            graph[j][k] = 1;
                            graph[k][j] = -1;
                        }
                        if (graph[j][i] == -1 && graph[i][k] == -1) {
                            graph[j][k] = -1;
                            graph[k][j] = 1;
                        }
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                boolean canDecision = true;
                for (int j = 0; j < n; j++) {
                    if(i == j) continue;
                    if (graph[i][j] == 0) {
                        canDecision = false;
                        break;
                    }
                }
                if (canDecision) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Problem2 prom = new Problem2();
        Solution sol = prom.new Solution();

        int n1 = 5;
        int[][] results1 = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };

        System.out.println(sol.solution(n1, results1)); // 기대 출력: 2

    }
}

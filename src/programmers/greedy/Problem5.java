package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem5 {
    private class Solution {
        public int solution(int[][] routes) {
            if (routes == null || routes.length == 0) {
                return 0;
            }
            Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

            int cameraCount = 1;
            int lastCameraPos = routes[0][1];

            for (int i = 1; i < routes.length; i++) {
                int currentStart = routes[i][0];
                int currentEnd = routes[i][1];

                if (currentStart > lastCameraPos) {
                    cameraCount++;
                    lastCameraPos = currentEnd;
                }
            }

            return cameraCount;
        }
    }
    public static void main(String[] args) {
        Problem5 prom = new Problem5();
        Solution sol = prom.new Solution();
        System.out.println(sol.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}

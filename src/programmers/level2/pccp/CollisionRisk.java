package programmers.level2.pccp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CollisionRisk {
    private static final class PosTime {
        final int r, c, t;

        PosTime(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PosTime)) return false;

            PosTime posTime = (PosTime) o;
            return r == posTime.r && c == posTime.c && t == posTime.t;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, t);
        }
    }

    public int solution(int[][] points, int[][] routes) {
        Map<PosTime, Integer> visit = new HashMap<>();
        int collisions = 0;

        for (int[] route : routes) {
            int time = 0;

            int curR = points[route[0] - 1][0];
            int curC = points[route[0] - 1][1];
            collisions += put(visit, curR, curC, time);

            for (int i = 1; i < route.length; i++) {
                int[] tgt = points[route[i] - 1];

                while (curR != tgt[0]) {
                    curR += (curR < tgt[0]) ? 1 : -1;
                    collisions += put(visit, curR, curC, ++time);
                }

                while (curC != tgt[1]) {
                    curC += (curC < tgt[1]) ? 1 : -1;
                    collisions += put(visit, curR, curC, ++time);
                }
            }
        }
        return collisions;
    }

    private int put(Map<PosTime, Integer> map, int r, int c, int t) {
        PosTime key = new PosTime(r, c, t);          // ★ 새 객체
        int cnt = map.getOrDefault(key, 0) + 1;
        map.put(key, cnt);
        return (cnt == 2) ? 1 : 0;                   // 두 번째 이상이면 위험 1회
    }

    public static void main(String[] args) {
        CollisionRisk problem = new CollisionRisk();
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {2, 4}};
        System.out.println(problem.solution(points, routes));

        int[][] points1 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes1 = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        System.out.println(problem.solution(points1, routes1));

        int[][] points2 = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes2 = {{2, 3, 4, 5}, {1, 3, 4, 5}};
        System.out.println(problem.solution(points2, routes2));
    }
}

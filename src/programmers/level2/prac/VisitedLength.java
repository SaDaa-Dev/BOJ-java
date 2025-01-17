package programmers.level2.prac;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 레벨2/방문길이
public class VisitedLength {
    private class Path {
        int x1, y1, x2, y2;


        public Path(int x1, int y1, int x2, int y2) {
            if (x1 > x2 || (x1 == x2 && y1 > y2)) {
                this.x1 = x2; this.y1 = y2;
                this.x2 = x1; this.y2 = y1;
            } else {
                this.x1 = x1; this.y1 = y1;
                this.x2 = x2; this.y2 = y2;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path path = (Path) o;
            return x1 == path.x1 && y1 == path.y1 && x2 == path.x2 && y2 == path.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }


    public int solution(String dirs) {
        int x = 0, y = 0;
        Set<Path> visitedPath = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            int oldX = x, oldY = y;

            // 이동
            switch (dir) {
                case 'U': if (y < 5) y++; break;
                case 'D': if (y > -5) y--; break;
                case 'R': if (x < 5) x++; break;
                case 'L': if (x > -5) x--; break;
            }

            if (oldX != x || oldY != y) {
                visitedPath.add(new Path(oldX, oldY, x, y));
            }
        }

        return visitedPath.size();
    }

    public static void main(String[] args) {
        VisitedLength prom = new VisitedLength();
        System.out.println(prom.solution("ULURRDLLU"));
//        System.out.println(prom.solution("LULLLLLLU"));
    }
}

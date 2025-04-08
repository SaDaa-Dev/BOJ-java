package programmers.level2.prac;

public class TwoCircle {
    public long solution(int r1, int r2) {
        long firstQuadrant = 0;
        long axis = 0;


        firstQuadrant += (long) r2 - r1 + 1;
        axis += (long) r2 - r1 + 1;

        for (long x = 1; x <= r2; x++) {
            long yMax = (long) Math.floor(Math.sqrt((long) r2 * r2 - x * x));

            long inner = (long) r1 * r1 - x * x;
            long yMin = (inner <= 0) ? 0
                    : (long) Math.ceil(Math.sqrt(inner));

            firstQuadrant += yMax - yMin + 1;

            if (yMin == 0) axis++;
        }

        long answer = firstQuadrant * 4
                - axis * 2;

        return answer;
    }

    public static void main(String[] args) {
        TwoCircle problem = new TwoCircle();
        System.out.println(problem.solution(2, 3));
    }
}

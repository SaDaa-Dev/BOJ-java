package programmers.level2.prac;

public class PickDot {
    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x = x + k) {
            long maxY = canMaxY(x, d);
            answer += (maxY / k) + 1;
        }

        return answer;
    }

    private long canMaxY(int x, int d) {
        return (long) Math.sqrt((long) d * d - (long) x * x);
    }

    public static void main(String[] args) {
        PickDot problem = new PickDot();
        System.out.println(problem.solution(1, 5));
    }
}

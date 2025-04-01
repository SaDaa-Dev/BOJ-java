package programmers.level2.pccp;

public class PuzzleGameChallenge {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;

        while (left < right) {
            long level = (left + right) / 2;
            long totalTime = calculateTime(diffs, times, level);

            if (limit >= totalTime) {
                right = level;
            } else {
                left += 1;
            }
        }

        return (int) left;
    }

    private long calculateTime(int[] diffs, int[] times, long level) {
        long time = 0;
        for (int i = 0; i < diffs.length; i++) {
            long failCnt = diffs[i] - level;
            int currTime = times[i];

            if (failCnt > 0) {
                int prevTime = i == 0 ? 0 : times[i - 1];
                long totalTime = (prevTime + currTime) * failCnt + currTime;

                time += totalTime;
            } else {
                time += currTime;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        PuzzleGameChallenge problem = new PuzzleGameChallenge();
        int[] diffs = {1, 328, 467, 209, 54};
        int[] times = {2, 7, 1, 4, 3};
        int limit = 1723;
        System.out.println(problem.solution(diffs, times, limit));
    }

}

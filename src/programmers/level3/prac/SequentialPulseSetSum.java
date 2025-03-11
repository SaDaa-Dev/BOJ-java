package programmers.level3.prac;

public class SequentialPulseSetSum {
    public long solution(int[] sequence) {
        long maxSum1 = maxSumPulse(sequence, 1);
        long maxSum2 = maxSumPulse(sequence, -1);

        return Math.max(maxSum1, maxSum2);
    }

    private long maxSumPulse(int[] sequence, int startPulse) {
        long currentSum = sequence[0] * pulseAt(0, startPulse);
        long maxSum = currentSum;

        for (int i = 1; i < sequence.length; i++) {
            int value = sequence[i] * pulseAt(i, startPulse);
            currentSum = Math.max(value, currentSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    private int pulseAt(int i, int startPulse) {
        return (i % 2 == 0) ? startPulse : -startPulse;
    }

    public static void main(String[] args) {
        SequentialPulseSetSum problem = new SequentialPulseSetSum();
        int[] input = {2, 3, -6, 1, 3, -1, 2, 4};
        problem.solution(input);
    }
}

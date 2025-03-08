package programmers.level2.prac;

import java.util.Arrays;

public class DifferentTwoBit {

    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++;
            answer[i] += ((answer[i] ^ numbers[i]) >> 2);
        }
        return answer;
    }
    public static void main(String[] args) {
        DifferentTwoBit problem = new DifferentTwoBit();
        long[] numbers = {2, 7};
        long[] result = problem.solution(numbers);
        System.out.println(Arrays.toString(result));
    }
}

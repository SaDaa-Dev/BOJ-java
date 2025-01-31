package programmers.level2.prac;

import java.util.Arrays;

public class DifferentBit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            String originBinary = Long.toBinaryString(num);

            while (true) {
                num++;
                String targetBinary = Long.toBinaryString(num);
                int diffCnt = 0;

                if (targetBinary.length() != originBinary.length()) break;

                for (int j = 0; j < originBinary.length(); j++) {
                    if (originBinary.charAt(j) != targetBinary.charAt(j)) {
                        diffCnt++;
                    }
                }

                if (diffCnt > 0 && diffCnt <= 2) {
                    break;
                }
            }

            answer[i] = num;
        }



        return answer;
    }
    public static void main(String[] args) {
        DifferentBit problem = new DifferentBit();
        System.out.println("problem.solution(new long[]{2, 7}) = " + Arrays.toString(problem.solution(new long[]{2, 7})));
    }
}

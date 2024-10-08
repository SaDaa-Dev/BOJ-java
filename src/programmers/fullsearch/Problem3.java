package programmers.fullsearch;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(solution("123"));
    }

    public static int solution(String numbers) {
        int primeCnt = 0;
        Set<Integer> combinatedNumbers = new HashSet<>();

        // 모든 조합 재귀
        permute("", numbers, combinatedNumbers);


        for (Integer combinatedNumber : combinatedNumbers) {
            System.out.println(combinatedNumber + " ");
            if(isPrime(combinatedNumber)){
                primeCnt++;
            }
        }

        return primeCnt;
    }

    private static boolean isPrime(Integer combinatedNumber) {
        int cntFlag = 0;
        for (int i = 1; i <= combinatedNumber; i++) {
            if (combinatedNumber % i == 0) {
                cntFlag++;
            }
        }

        if (cntFlag == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void permute(String prefix, String numbers, Set<Integer> combinatedNumbers) {
        if (!prefix.isEmpty()) {
            combinatedNumbers.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < numbers.length(); i++) {
            permute(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1), combinatedNumbers);
        }
    }
}

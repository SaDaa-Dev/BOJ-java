package programmers.level2.kakao;


import java.util.ArrayList;

public class FindPrime {
    public int solution(int n, int k) {
        int answer = -1;
        String convertedStr = convertEssenceFromK(n, k);
        ArrayList<Integer> primes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < convertedStr.length(); i++) {
            char curr = convertedStr.charAt(i);
            if (curr != '0') {
                sb.append(curr);
            } else {
                sb.append(',');
            }
        }
        String[] splited = sb.toString().split(",");

        int primeCnt = 0;
        for (String strNum : splited) {
            if (strNum.isEmpty()) continue;

            long parsed = Long.parseLong(strNum);
            if (parsed > 1 && isPrime(parsed)) {
                primeCnt++;
            }
        }
        return primeCnt;
    }

    private boolean isPrime(long number) {
        if (number < 2) return false;
        long limit = (long) Math.sqrt(number);
        for (long i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private String convertEssenceFromK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            int remainder = n % k;
            n = n / k;
            sb.append(remainder);
        }
        sb.append(n);

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        FindPrime problem = new FindPrime();
        System.out.println(problem.solution(437674, 3));

    }
}

package programmers.level2.prac;

import java.security.spec.RSAOtherPrimeInfo;

public class NextBigInt {
    // n의 다음 큰 수는 2진수 변환 시 1의 갯수가 같다. (toBinaryString) -> 1의 갯수 비교
    // 1, 2 조건 중 가장 작은 수 (Break 조건)
    // 입력 크기 : 100만
    public int solution(int n) {
        int originBitCount = Integer.bitCount(n);
        while (true) {
            n++; // n 비포함
            int newBitCount = Integer.bitCount(n);
            if (originBitCount == newBitCount) {
                return n;
            }
        }
    }

    public static void main(String[] args) {
        NextBigInt prom = new NextBigInt();
        System.out.println(prom.solution(15));
    }
}

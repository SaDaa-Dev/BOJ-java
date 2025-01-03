package programmers.level2.prac;

import java.util.Arrays;

// 최소공배수
// 각 숫자의 최대공약수들의 곱 -> 최소 공배수
public class CommonMinNum {
    public int solution(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        CommonMinNum prom = new CommonMinNum();
        int[] input = {2,6,8,14};
        System.out.println(prom.solution(input));
    }
}

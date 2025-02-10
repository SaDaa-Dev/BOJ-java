package programmers.level2.prac;

public class DivideNumberCard {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);

        if(checkCandidate(gcdA, arrayB)) answer = Math.max(answer, gcdA);
        if(checkCandidate(gcdB, arrayA)) answer = Math.max(answer, gcdB);

        return answer;
    }

    private boolean checkCandidate(int gcd, int[] arr) {
        for (int num : arr) {
            if (num % gcd == 0) {
                return false;
            }
        }
        return true;
    }

    private int gcdArray(int[] arr) {
        int g = arr[0];
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i]);
            if (g == 1) {
                return 1;
            }
        }
        return g;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        DivideNumberCard problem = new DivideNumberCard();
        int[] arr1 = {10, 20};
        int[] arr2 = {5, 17};
        System.out.println(problem.solution(arr1, arr2));
    }
}

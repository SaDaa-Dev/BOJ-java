package programmers.level2.prac;

public class NumberExpression {
    public int solution(int n) {
        int result = 1; // 자기 자신 더했을 때 1 추가됨
        for (int i = 1; i < n; i++) {
            int sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;

                if (sum >= n) {
                    if (sum == n) {
                        result++;
                    }
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        NumberExpression prom = new NumberExpression();
        System.out.println(prom.solution(15));
    }
}

package programmers.level2.prac;

public class MagicElevator {
    // 층 수 1억
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int remainder = storey % 10;
            storey /= 10;

            if (remainder > 5 || (remainder == 5 && storey % 10 >= 5)) {
                answer += (10 - remainder);
                storey++;
            } else {
                answer += remainder;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        MagicElevator problem = new MagicElevator();
        System.out.println("problem.solution(2554) = " + problem.solution(2554));
        System.out.println("problem.solution(16) = " + problem.solution(16));
    }
}

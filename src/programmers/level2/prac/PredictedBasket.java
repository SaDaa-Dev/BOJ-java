package programmers.level2.prac;

public class PredictedBasket {
    public int solution(int n, int a, int b) {
        int round = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }

    public static void main(String[] args) {
        PredictedBasket prom = new PredictedBasket();
        System.out.println(prom.solution(8, 4, 7));
    }
}

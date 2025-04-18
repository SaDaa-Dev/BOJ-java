package programmers.level2.kakao;

public class DeliveryAndReturn {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int remainD = 0;
        int remainP = 0;

        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            remainD += deliveries[i];
            remainP += pickups[i];

            while (remainD > 0 || remainP > 0) {
                remainD -= cap;
                remainP -= cap;
                cnt++;
            }

            totalDistance += (i + 1) * 2 * cnt;
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        DeliveryAndReturn problem = new DeliveryAndReturn();
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        System.out.println(problem.solution(4, 5, deliveries, pickups));
    }
}

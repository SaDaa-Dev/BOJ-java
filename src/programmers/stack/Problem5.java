package programmers.stack;

import javax.naming.LinkException;
import java.util.LinkedList;
import java.util.Queue;

public class Problem5 {
    public static void main(String[] args) {
        int[] data = {7,4,5,6};
        System.out.println("solution({7,4,5,6}) = " + solution(2, 10, data));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
       Queue<Integer> bridge = new LinkedList<>();
       int time = 0;
       int weightOnBridge = 0;
       int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++;
            weightOnBridge -= bridge.poll();

            if (idx < truck_weights.length) {
                if (weightOnBridge + truck_weights[idx] <= weight) {
                    bridge.add(truck_weights[idx]);
                    weightOnBridge += truck_weights[idx];
                    idx++;
                } else {
                    bridge.add(0);
                }
            }
        }

        return time;
    }
}

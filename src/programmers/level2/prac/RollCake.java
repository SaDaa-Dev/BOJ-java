package programmers.level2.prac;

import java.util.HashMap;

public class RollCake {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> right = new HashMap<>();
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        int rightDistinct = right.size();
        HashMap<Integer, Integer> left = new HashMap<>();
        int leftDistinct = 0;

        int result = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            left.put(t, left.getOrDefault(t, 0) + 1);
            if (left.get(t) == 1) {
                leftDistinct++;
            }

            right.put(t, right.get(t) - 1);
            if (right.get(t) == 0) {
                right.remove(t);
                rightDistinct--;
            }


            if (leftDistinct == rightDistinct) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        RollCake prom = new RollCake();
        int[] input = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(prom.solution(input));
    }
}

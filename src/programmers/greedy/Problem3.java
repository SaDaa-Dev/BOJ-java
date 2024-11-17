package programmers.greedy;

import java.util.Arrays;

public class Problem3 {
    private class Sol {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);

            int left = 0;
            int right = people.length - 1;
            int boatCount = 0;

            while (left <= right) {
                if (people[left] + people[right] <= limit) {
                    left++;
                }

                right--;
                boatCount++;
            }

            return boatCount;
        }
    }
    public static void main(String[] args) {
        Problem3 prob = new Problem3();
        Sol sol = prob.new Sol();
        System.out.println(sol.solution(new int[]{70, 50, 80, 50}, 100));
    }
}

package programmers.greedy;

import java.util.Arrays;

public class Problem1 {

    public class Sol {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] list = new int[n];
            Arrays.fill(list, 1);

            for (int l : lost) {
                list[l - 1]--;
            }

            for (int r : reserve) {
                list[r - 1]++;
            }

            for (int i = 0; i < n; i++) {
                if (list[i] == 0) {
                    if (i > 0 && list[i - 1] > 1) {
                        list[i - 1]--;
                        list[i]++;
                    }
                    else if (i < n - 1 && list[i + 1] > 1) {
                        list[i + 1]--;
                        list[i]++;
                    }
                }
            }

            int answer = 0;
            for (int uniform : list) {
                if (uniform >= 1) {
                    answer++;
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Problem1 prom = new Problem1();
        Sol sol = prom.new Sol();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(sol.solution(n, lost, reserve));
    }
}

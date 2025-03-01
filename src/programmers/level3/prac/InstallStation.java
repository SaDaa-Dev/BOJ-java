package programmers.level3.prac;

import java.util.Arrays;

public class InstallStation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;
        Arrays.sort(stations);

        for (int station : stations) {
            int left = station - w;
            if (start < left) {
                int gap = left - start;
                answer += (gap + coverage - 1) / coverage;
            }
            start = station + w + 1;
        }

        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
    public static void main(String[] args) {
        InstallStation problem = new InstallStation();
        // 16	[9]	 2	3
        System.out.println(problem.solution(16, new int[]{9}, 2));
    }
}

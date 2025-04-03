package programmers.level3.prac;

import java.util.Arrays;

public class PerformanceReview {

    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int rank = 1;
        int maxScore = 0;
        int wTotal = wanho[0] + wanho[1];

        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] score : scores) {
            if (maxScore <= score[1]) {
                maxScore = score[1];
                if (score[0] + score[1] > wTotal) rank++;
            } else {
                if(score.equals(wanho)) return -1;
            }
        }

        return rank;
    }


    // 시간 초과
//    public int solution(int[][] scores) {
//        int answer = 0;
//        ArrayList<int[]> list = new ArrayList<>();
//
//        for (int i = 0; i < scores.length; i++) {
//            if (isPossible(scores, i)) { // 인센티브 지급 대상자
//                int scoreSum = Arrays.stream(scores[i]).sum();
//                list.add(new int[]{scoreSum, i});
//            } else {
//                if (i == 0) { // 완호가 인센티브 비대상자
//                    return -1;
//                }
//            }
//        }
//
//        list.sort(Comparator.comparingInt((int[] o) -> o[0]).reversed());
//
//        for (int i = 0; i < list.size(); i++) {
//            int[] curr = list.get(i);
//            if (curr[1] == 0) {
//                answer = i + 1;
//            }
//        }
//
//        return answer;
//    }
//
//    private boolean isPossible(int[][] scores, int currIdx) {
//        int n = scores.length;
//        int attitudeReview = scores[currIdx][0];
//        int coworkerReview = scores[currIdx][1];
//
//        for (int i = 0; i < n; i++) {
//            if (currIdx == i) {
//                continue;
//            }
//            int attitudeScore = scores[i][0];
//            int coworkerScore = scores[i][1];
//
//            if (attitudeReview < attitudeScore && coworkerReview < coworkerScore) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        PerformanceReview problem = new PerformanceReview();
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        System.out.println(problem.solution(scores));
    }
}

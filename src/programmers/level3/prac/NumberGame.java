package programmers.level3.prac;

import java.util.Arrays;

public class NumberGame {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int winScore = 0;
        int pointer = 0;

        for (int i = 0; i < A.length && pointer < B.length; i++) {
            while (pointer < B.length && B[pointer] <= A[i]) {
                pointer++;
            }
            if (pointer < B.length) {
                winScore++;
                pointer++;
            }
        }


        return winScore;
    }

//    private List<List<Integer>> combinations = new ArrayList<>();
    //        // 모든 순열 생성
//        dfs(B, 0, new ArrayList<>());
//
//        for (List<Integer> combination : combinations) {
//            int winScore = 0;
//            for (int i = 0; i < A.length; i++) {
//                int aScore = A[i];
//                int bScore = combination.get(i);
//
//                if (aScore < bScore) {
//                    winScore++;
//                }
//            }
//
//            answer = Math.max(answer, winScore);
//        }

//    private void dfs(int[] arr, int mask, ArrayList<Integer> perm) {
//        if (perm.size() == arr.length) {
//            combinations.add(new ArrayList<>(perm));
//            return;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if ((mask & (1 << i)) == 0) {
//                perm.add(arr[i]);
//                dfs(arr, mask | (1 << i), perm);
//                perm.remove(perm.size() - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        NumberGame problem = new NumberGame();
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        System.out.println(problem.solution(a, b));
    }
}

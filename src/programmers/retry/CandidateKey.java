package programmers.retry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
    private List<Integer> candidateKeys = new ArrayList<>();
    private int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        for (int subset = 0; subset < (1 << col); subset++) {
            // 유일성 검사
            if (!checkUnique(relation, subset, row, col)) {
                continue;
            }

            // 최소성 검사
            boolean isMinimal = true;
            for (int key : candidateKeys) {
                if ((subset & key) == key) {
                    isMinimal = false;
                    break;
                }
            }

            if (isMinimal) {
                candidateKeys.add(subset);
            }
        }


        return candidateKeys.size();
    }

    private boolean checkUnique(String[][] relation, int subset, int row, int col) {
        Set<String> set = new HashSet<>();
        for (int r = 0; r < row; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < col; c++) {
                if ((subset & (1 << c)) != 0) {
                    sb.append(relation[r][c]).append("|");
                }
            }

            if (set.contains(sb.toString())) {
                return false;
            }

            set.add(sb.toString());
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] inputs = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        CandidateKey prom = new CandidateKey();
        System.out.println(prom.solution(inputs));
    }
}

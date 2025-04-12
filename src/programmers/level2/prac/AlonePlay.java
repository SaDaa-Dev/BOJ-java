package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlonePlay {
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;

        ArrayList<List> groups = new ArrayList<>();

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                groups.add(dfs(cards, visited, i, new ArrayList<>()));
            }
        }

        if (groups.size() <= 1) {
            return 0;
        } else {
            groups.sort(Comparator.comparingInt(List::size));
            Collections.reverse(groups);
            return groups.get(0).size() * groups.get(1).size();
        }
    }

    private List dfs(int[] cards, boolean[] visited, int idx, ArrayList<Integer> groupCandidates) {
        visited[idx] = true;
        groupCandidates.add(cards[idx]);

        int nextTargetIdx = cards[idx] - 1;
        if (!visited[nextTargetIdx]) {
            dfs(cards, visited, nextTargetIdx, groupCandidates);
        }

        return groupCandidates;
    }

    public static void main(String[] args) {
        AlonePlay problem = new AlonePlay();
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        System.out.println(problem.solution(cards));

    }
}

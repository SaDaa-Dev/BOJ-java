package programmers.level2.kakao;

import java.util.*;

public class RankSearch {
    private Map<String, List<Integer>> db = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        makeDb(info);
        sortScore(db);

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] parts = q.split(" ");
            String key = String.join(" ", parts[0], parts[1], parts[2], parts[3]);
            int targetScore = Integer.parseInt(parts[4]);

            List<Integer> scores = db.getOrDefault(key, Collections.emptyList());
            answer[i] = scores.isEmpty() ? 0 : countGE(scores, targetScore);
        }

        return answer;
    }

    private int countGE(List<Integer> scores, int targetScore) {
        int lo = 0, hi = scores.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (scores.get(mid) < targetScore) lo = mid + 1;
            else hi = mid;
        }
        return scores.size() - lo;
    }

    private void sortScore(Map<String, List<Integer>> db) {
        for (List<Integer> value : db.values()) {
            Collections.sort(value);
        }
    }

    private void makeDb(String[] info) {
        for (String people : info) {
            String[] p = people.split(" ");
            String[] infos = {p[0], p[1], p[2], p[3]};
            int score = Integer.parseInt(p[4]);

            int n = infos.length;
            for (int mask = 0; mask < (1 << n); mask++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append((mask & (1 << i)) != 0 ? infos[i] : "-");
                    if (i < 3) {
                        sb.append(" ");
                    }
                }

                db.computeIfAbsent(sb.toString(), x -> new ArrayList<>())
                        .add(score);
            }
        }
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        RankSearch problem = new RankSearch();
        System.out.println(Arrays.toString(problem.solution(info, query)));
    }
}

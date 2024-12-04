package programmers.dfsbfs;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private class Solution {
        private HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        private List<String> route = new LinkedList<>();

        public String[] solution(String[][] tickets) {
            for (String[] ticket : tickets) {
                String from = ticket[0];
                String to = ticket[1];

                map.putIfAbsent(from, new PriorityQueue<>());
                map.get(from).add(to);
            }

            dfs("ICN");
            return route.toArray(new String[0]);
        }

        private void dfs(String current) {
            PriorityQueue<String> destinations = map.get(current);
            while (destinations != null && !destinations.isEmpty()) {
                String next = destinations.poll();
                dfs(next);
            }
            route.add(0, current); // 역순으로 추가
        }
    }
    public static void main(String[] args) {
        Problem6 prom = new Problem6();
        Solution sol = prom.new Solution();
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        for (String s : sol.solution(tickets)) {
            System.out.println(s);
        }
    }
}

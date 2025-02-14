package programmers.level3.kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadUser {
    private Set<Set<String>> validCombination = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> candidateBannedUsers = new ArrayList<>();
        for (String ban : banned_id) {
            String regex = ban.replace("*", "[a-z0-9]");
            List<String> matchingUsers = new ArrayList<>();
            for (String user : user_id) {
                if (user.length() != ban.length()) continue;
                if (user.matches(regex)) {
                    matchingUsers.add(user);
                }
            }

            candidateBannedUsers.add(matchingUsers);
        }

        dfs(candidateBannedUsers, 0, new HashSet<>());

        return validCombination.size();
    }

    private void dfs(List<List<String>> candidateBannedUsers, int idx, Set<String> currentSet) {
        if (idx == candidateBannedUsers.size()) {
            validCombination.add(new HashSet<>(currentSet));
            return;
        }

        for (String user : candidateBannedUsers.get(idx)) {
            if (currentSet.contains(user)) continue;

            currentSet.add(user);
            dfs(candidateBannedUsers, idx + 1, currentSet);
            currentSet.remove(user);
        }
    }

    public static void main(String[] args) {
        BadUser problem = new BadUser();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        System.out.println("problem.solution(user_id, banned_id) = " + problem.solution(user_id, banned_id));
    }
}

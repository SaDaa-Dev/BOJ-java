package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaximizeExp {
    private HashSet<String> exp = new HashSet<>();
    private List<List<String>> combinations = new ArrayList<>();
    public long solution(String expression) {
        long answer = 0;

        // 토큰화 (연산과 상수 분리)
        String[] tokenized = tokenize(expression);

        // 연산자 순열 조합 생성
        makeComb(exp.toArray(new String[0]), new boolean[exp.size()], new ArrayList<>());

        for (List<String> combination : combinations) {
            long result = calculatePermutation(new ArrayList<>(Arrays.asList(tokenized)), combination);
            answer = Math.max(answer, Math.abs(result));
        }

        return answer;
    }

    private long calculatePermutation(ArrayList<String> tokens, List<String> combination) {
        for (String ex : combination) {
            while (tokens.contains(ex)) {
                ArrayList<String> newTokens = new ArrayList<>();
                for (int i = 0; i < tokens.size(); i++) {
                    String token = tokens.get(i);
                    if(token.equals(ex)) {
                        long left = Long.parseLong(newTokens.remove(newTokens.size()-1));
                        long right = Long.parseLong(tokens.get(++i)); // i+1번 토큰
                        long computed = 0;
                        if(ex.equals("+")) {
                            computed = left + right;
                        } else if(ex.equals("-")) {
                            computed = left - right;
                        } else if(ex.equals("*")) {
                            computed = left * right;
                        }
                        newTokens.add(String.valueOf(computed));
                    } else {
                        newTokens.add(token);
                    }
                }
                tokens = newTokens;
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    private void makeComb(String[] exp, boolean[] used, ArrayList<String> current) {
        if (current.size() == exp.length) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < exp.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(exp[i]);
                makeComb(exp, used, current);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    private String[] tokenize(String expression) {
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
                exp.add(String.valueOf(c));
                tokens.add(String.valueOf(c));
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            tokens.add(current.toString());
        }

        return tokens.toArray(new String[0]);
    }

    public static void main(String[] args) {
        MaximizeExp problem = new MaximizeExp();
        problem.solution("50*6-3*2");
    }
}

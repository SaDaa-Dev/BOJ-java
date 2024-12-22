package programmers.level2.prac;

public class JadenCase {
    public String solution(String s) {
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        boolean isStart = true;
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);

            if (c == ' ') {
                sb.append(c);
                isStart = true;
            } else {
                if (isStart && Character.isLetter(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
                isStart = false;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "3people unFollowed me";
        JadenCase prom = new JadenCase();
        System.out.println(prom.solution(input));
    }
}

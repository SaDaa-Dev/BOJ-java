package programmers.level2.prac;

public class Country124 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % 3;
            if (r == 0) {
                sb.append("4");
                n = (n - 1) / 3;
            } else {
                sb.append(r);
                n = n / 3;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Country124 problem = new Country124();
        System.out.println(problem.solution(10));
    }
}

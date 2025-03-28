package programmers.level2.kakao;

public class CompressionStr {
    public int solution(String s) {
        int answer = s.length(); // 압축하지 않은 문자열의 길이를 기본값으로 설정

        for (int step = 1; step <= s.length() / 2; step++) {
            String prev = s.substring(0, step);
            int cnt = 1;
            StringBuilder compressed = new StringBuilder();

            for (int j = step; j <= s.length(); j += step) {
                String curr = (j + step > s.length()) ? s.substring(j) : s.substring(j, j + step);
                System.out.print(", " + curr);
                if (prev.equals(curr)) {
                    cnt++;
                } else {
                    // 압축된 결과 추가
                    compressed.append((cnt > 1 ? cnt : "")).append(prev);
                    prev = curr; // prev 문자열을 현재 문자열로 변경
                    cnt = 1; // 카운트 초기화
                }
            }
            compressed.append((cnt > 1 ? cnt : "")).append(prev);

            // 최소값 갱신
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
    public static void main(String[] args) {
        CompressionStr problem = new CompressionStr();
        problem.solution("ababcdcdababcdcd");
    }
}

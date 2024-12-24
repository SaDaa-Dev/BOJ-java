package programmers.level2.prac;

public class ConvertBinaryRepeat {

    public int[] solution(String s) {
        int throwZeroCnt = 0;
        int convertCnt = 0;

        while (s.length() > 1) {
            int originLen = s.length();

            // 1) '0' 제거
            s = s.replace("0", "");
            int newLen = s.length();  // 남은 '1'의 개수

            // 2) 제거된 '0' 누적
            throwZeroCnt += (originLen - newLen);

            // 3) 남아있는 '1'의 개수를 이진수 문자열로 변환
            s = Integer.toBinaryString(newLen);

            convertCnt++;
        }

        return new int[]{convertCnt, throwZeroCnt};
    }
    public static void main(String[] args) {
        ConvertBinaryRepeat prom = new ConvertBinaryRepeat();
        String input = "110010101001";
        prom.solution(input);
    }
}

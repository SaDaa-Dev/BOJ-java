package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = new String[5];

        int maxLength = 0;

        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
            // 가장 긴 문자열의 길이 업데이트
            maxLength = Math.max(maxLength, lines[i].length());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; i++) { // 각 열에 대해
            for (int j = 0; j < 5; j++) { // 각 행(문자열)에 대해
                if (i < lines[j].length()) { // 현재 열의 문자가 존재하는 경우에만
                    result.append(lines[j].charAt(i)); // 결과에 추가
                }
            }
        }

        System.out.println(result);

    }
}

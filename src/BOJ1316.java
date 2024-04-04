import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 단어의 개수 입력받기
        int count = 0; // 그룹 단어의 개수를 저장할 변수

        for (int i = 0; i < N; i++) {
            if (isGroupWord(scanner.next())) { // 단어를 입력받아 그룹 단어인지 판별
                count++;
            }
        }

        System.out.println(count); // 그룹 단어의 개수 출력
    }

    public static boolean isGroupWord(String word) {
        boolean[] check = new boolean[26]; // 알파벳이 이전에 나왔는지 체크할 배열
        int prev = 0; // 이전 문자를 저장할 변수

        for (int i = 0; i < word.length(); i++) {
            int now = word.charAt(i); // 현재 문자

            if (prev != now) { // 이전 문자와 현재 문자가 다른 경우
                if (check[now - 'a']) { // 현재 문자가 이전에 이미 나온 경우
                    return false; // 그룹 단어가 아님
                }
                check[now - 'a'] = true; // 현재 문자를 체크
                prev = now; // 이전 문자를 현재 문자로 업데이트
            }
        }
        return true; // 모든 검사를 통과하면 그룹 단어임
    }
}

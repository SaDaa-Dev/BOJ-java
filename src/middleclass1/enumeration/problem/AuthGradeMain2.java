package middleclass1.enumeration.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthGradeMain2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN] : ");
        String answer = br.readLine();

        AuthGrade answeredGrade = AuthGrade.valueOf(answer.toUpperCase());
        System.out.println("당신의 등급은 " + answeredGrade.getDescription() + "입니다.");
        System.out.println("==== 메뉴 목록 ====");

        if (answeredGrade.getLevel() > 0) {
            System.out.println("- 메인 화면");
        }
        if (answeredGrade.getLevel() > 1) {
            System.out.println("- 이메일 관리 화면");
        }
        if (answeredGrade.getLevel() > 2) {
            System.out.println("- 관리자 화면");
        }

    }
}

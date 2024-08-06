package middleclass.enumeration.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static middleclass.enumeration.problem2.HttpStatus.OK;

public class HttpStatusMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("HTTP CODE : ");
        Integer code = Integer.valueOf(br.readLine());

        HttpStatus status = HttpStatus.findByCode(code);

        if (code == null) {
            System.out.println("정의되지 않은 코드입니다.");
        } else {
            System.out.println(status.getCode() + " " + status.getMessage());
            System.out.println("isSuccess = " + status.isSuccess());
        }
    }
}

package middleclass2.collection.map.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DictionaryTest {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("영단어 입력하세요 :");
                String englishWord = br.readLine();
                System.out.println("한글 뜻 입력하세요 :");
                String koreanWord = br.readLine();

            } catch (IOException e) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}

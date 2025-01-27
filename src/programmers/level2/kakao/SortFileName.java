package programmers.level2.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortFileName {
    // 전처리 => Head, Number, Tail 자르기
    // Head와 Number를 기준으로 정렬 기준으로 정렬 (기존 Idx 가지고 있기) , Head는 대소문자 구분 X
    // 정렬 완료된 이후. Idx로 파일 출력하기
    private class FilePart {
        String originName;
        String head;
        int number;
        int idx;

        public FilePart(String originName, String head, int number, int idx) {
            this.originName = originName;
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
    }
    public String[] solution(String[] files) {
        ArrayList<FilePart> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(parseFile(files[i], i));
        }
        list.sort(Comparator.comparing((FilePart o) -> o.head).thenComparingInt(o -> o.number));

        String[] result = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).originName;
        }

        return result;
    }

    private FilePart parseFile(String file, int idx) {
        int i = 0;
        StringBuilder headSb = new StringBuilder();
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            headSb.append(file.charAt(i));
            i++;
        }
        String head = headSb.toString();
        String lowerHead = head.toLowerCase();

        StringBuilder numSb = new StringBuilder();
        int numberStart = i;
        for (int count = 0; count < 5 && i < file.length(); count++) {
            char c = file.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            numSb.append(c);
            i++;
        }

        int number = 0;
        if (numSb.length() > 0) {
            number = Integer.parseInt(numSb.toString());
        }

        return new FilePart(file, lowerHead, number, idx);
    }

    public static void main(String[] args) {
        SortFileName problem = new SortFileName();
        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(problem.solution(input)));
    }
}

package boj.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> editorStr = new LinkedList<String>();

        String[] startStr = br.readLine().split("");

        for (String s : startStr) {
            editorStr.add(s);
        }

        ListIterator<String> ListIter = editorStr.listIterator(editorStr.size());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char command = input.charAt(0);

            switch (command) {
                case 'L':
                    if (ListIter.hasPrevious()) {
                        ListIter.previous();
                    }
                    break;
                case 'D':
                    if (ListIter.hasNext()) {
                        ListIter.next();
                    }
                    break;
                case 'B':
                    if (ListIter.hasPrevious()) {
                        ListIter.previous();
                        ListIter.remove();
                    }
                    break;
                case 'P':
                    char ch = input.charAt(2); // 추가할 문자 가져오기
                    ListIter.add(String.valueOf(ch));
                    break;
                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String ch : editorStr) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}

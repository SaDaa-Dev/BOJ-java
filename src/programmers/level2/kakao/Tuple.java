package programmers.level2.kakao;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        int[][] parsedData = convertAndSort(s);
        Set<Integer> set = new LinkedHashSet<>();
        for (int[] ints : parsedData) {
            for (int i = 0; i < ints.length; i++) {
                set.add(ints[i]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[][] convertAndSort(String s) {
        // 문자열 분리
        String[] splited = s.split("},");
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < splited.length; i++) {
            splited[i] = splited[i].replaceAll("\\{", "").replaceAll("}", "");
            list.add(Arrays.stream(splited[i].split(",")).mapToInt(Integer::valueOf).toArray());
        }
        // Sort
        Collections.sort(list, (o1, o2) -> {
            if (o1.length == o2.length) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1.length, o2.length);
        });


        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Tuple prom = new Tuple();
        String input = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println("prom.solution(input) = " + Arrays.toString(prom.solution(input)));
    }
}

package programmers.hash;

import java.util.*;

public class problem5 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        solution(genres, plays);
    }

    private static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> data = new HashMap<>();
        LinkedList<Integer> re = new LinkedList<>();

        for (int i = 0; i < genres.length; i++) {
            addGenrePlayCnt(data, genres[i], plays[i]);
        }

        while (!data.isEmpty()) {
            String maxGen = findMaxGenre(data);
            HashMap<Integer, Integer> tmpGen = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(maxGen)) {
                    tmpGen.put(i, plays[i]);
                }
            }

            List<Map.Entry<Integer, Integer>> sortedCnt = sortByCnt(tmpGen);
            for (int i = 0; i < Math.min(2, sortedCnt.size()); i++) {
                re.add(sortedCnt.get(i).getKey());
            }

            data.remove(maxGen);
        }

        System.out.println(re.toString());
        int[] converted = new int[re.size()];
        for (int i = 0; i < re.size(); i++) {
            converted[i] = re.get(i);
        }
        return converted;
    }


    private static List<Map.Entry<Integer, Integer>> sortByCnt(HashMap<Integer, Integer> tmpGen) {
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(tmpGen.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // Sort in descending order
        return list;
    }


    private static String findMaxGenre(HashMap<String, Integer> data) {
        String maxGen = null;
        int maxCnt = 0;

        for (Map.Entry<String, Integer> genreAndSum : data.entrySet()) {
            String gen = genreAndSum.getKey();
            int cnt = genreAndSum.getValue();

            if (cnt > maxCnt) {
                maxGen = gen;
                maxCnt = cnt;
            }
        }

        return maxGen;
    }

    private static void addGenrePlayCnt(HashMap<String, Integer> data, String genre, int playCnt) {
        int currentCnt = data.getOrDefault(genre, 0);

        data.put(genre, currentCnt + playCnt);
    }

}

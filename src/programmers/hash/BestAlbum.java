package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {
    private class Solution {
        private static class Song {
            private int idx;
            private int playCnt;

            public Song(int idx, int playCnt) {
                this.idx = idx;
                this.playCnt = playCnt;
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Integer> mapWithPlays = new HashMap<>();
            HashMap<String, List<Song>> mapWithSong = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int playCnt = plays[i];
                mapWithPlays.put(genre, mapWithPlays.getOrDefault(genre, 0) + playCnt);

                mapWithSong.putIfAbsent(genre, new ArrayList<>());
                mapWithSong.get(genre).add(new Song(i, playCnt));
            }

            ArrayList<String> sortedByPlayCnt = new ArrayList<>(mapWithPlays.keySet());
            sortedByPlayCnt.sort((o1, o2) -> mapWithPlays.get(o2).compareTo(mapWithPlays.get(o1)));
            ArrayList<Integer> result = new ArrayList<>();

            for (String genre : sortedByPlayCnt) {
                List<Song> songs = mapWithSong.get(genre);
                songs.sort((o1, o2) -> {
                    if (o1.playCnt != o2.playCnt) {
                        return Integer.compare(o2.playCnt, o1.playCnt);
                    } else {
                        return Integer.compare(o1.idx, o2.idx);
                    }
                });

                for (int i = 0; i < Math.min(2, songs.size()); i++) {
                    result.add(songs.get(i).idx);
                }

            }


            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        BestAlbum ba = new BestAlbum();
        Solution sol = ba.new Solution();

        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(sol.solution(genres1, plays1))); // 출력: [4, 1, 3, 0]
    }
}

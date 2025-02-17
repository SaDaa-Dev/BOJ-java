package programmers.level2.kakao;

public class JustNowMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        m = convertMelody(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int playTime = convertToMinute(parts[0], parts[1]);
            String name = parts[2];
            // 음악 멜로디도 변환
            String melody = convertMelody(parts[3]);
            // 재생 시간만큼의 멜로디 구하기
            String playedMelody = getPlayedMelody(melody, playTime);

            // m이 재생 멜로디에 포함되고, 재생 시간이 가장 긴 후보라면 업데이트
            if (playedMelody.contains(m) && playTime > maxPlayTime) {
                answer = name;
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private String getPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        int len = melody.length();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % len));
        }
        return sb.toString();
    }

    private String convertMelody(String melody) {
        melody = melody.replace("C#", "c");
        melody = melody.replace("D#", "d");
        melody = melody.replace("F#", "f");
        melody = melody.replace("G#", "g");
        melody = melody.replace("A#", "a");
        melody = melody.replace("B#", "b");
        return melody;
    }

    private int convertToMinute(String start, String end) {
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");
        int startTime = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
        int endTime = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
        return endTime - startTime;
    }

    public static void main(String[] args) {
        JustNowMusic problem = new JustNowMusic();

        String m = "ABCDEFG";
        String[] musicInfo = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(problem.solution(m, musicInfo));

        m = "CC#BCC#BCC#BCC#B";
        String[] musicInfo2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(problem.solution(m, musicInfo2));
    }
}

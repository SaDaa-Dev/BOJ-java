package programmers.level3.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        // 1. convert HH -> MM (Integer)
        // 2. 정렬후 Queue로 반환
        PriorityQueue<Integer> pq = convertToQueue(timetable);
        System.out.println(pq);


        int departureTime = 540; // 9시부터
        List<List<Integer>> bus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bus.add(new ArrayList<>());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()) {
                Integer crew = pq.poll();

                if (bus.get(i).size() < m && crew <= departureTime) {
                    bus.get(i).add(crew);
                    ans = crew - 1;
                } else {
                    pq.add(crew);
                    break;
                }
            }

            departureTime += t;
        }

        if (bus.get(n - 1).size() < m) {
            ans = departureTime - t;
        }

        answer += convertTimeToString(ans);

        return answer;
    }

    private PriorityQueue<Integer> convertToQueue(String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            pq.offer(convertTimeToMinute(time));
        }

        return pq;
    }

    private String convertTimeToString(int time){
        String hour = String.format("%02d", time/60);
        String min = String.format("%02d", time%60);
        return hour+":"+min;
    }

    private Integer convertTimeToMinute(String time) {
        String[] hhmm = time.split(":");

        int minuteByHour = Integer.parseInt(hhmm[0]) * 60;
        int minute = Integer.parseInt(hhmm[1]);

        return minuteByHour + minute;
    }

    public static void main(String[] args) {
        ShuttleBus problem = new ShuttleBus();
        String[] timeTable = {"09:10", "09:09", "08:00"};
        System.out.println(problem.solution(2, 10, 2, timeTable));
    }
}

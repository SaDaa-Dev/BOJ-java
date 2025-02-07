package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HotelRent {
    private class BookInfo {
        int startT;
        int endT;

        public BookInfo(String startT, String endT) {
            this.startT = convertToMinute(startT);
            this.endT = convertToMinute(endT) + 10;
        }
    }
    public int solution(String[][] book_time) {
        ArrayList<BookInfo> lists = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            String startT = book_time[i][0];
            String endT = book_time[i][1];
            lists.add(new BookInfo(startT, endT));
        }

        lists.sort(Comparator.comparingInt(o -> o.startT));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (BookInfo book : lists) {
            if (!pq.isEmpty() && pq.peek() <= book.startT) {
                pq.poll();
            }
            pq.offer(book.endT);
        }

        return pq.size();
    }

    private int convertToMinute(String timeStr) {
        String[] time = timeStr.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return (hour * 60) + minute;
    }

    public static void main(String[] args) {
        HotelRent problem = new HotelRent();
        String[][] inputs = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println("problem.solution(inputs) = " + problem.solution(inputs));
    }
}

package programmers.level2.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OpenChattingRoom {

    // 1. uid, name HashMap -> 최종이름만 반환
    // 2. Enter, Leave 와 uid를 저장하는 List
    // 3. 마지막에 Map 활용해서 list에 있는 uid 값을 치환하기
    private class Event {
        String uid;
        String type;

        public Event(String uid, String type) {
            this.uid = uid;
            this.type = type;
        }
    }

    public String[] solution(String[] record) {
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<Event> enterLeaveLists = new ArrayList<>();
        HashMap<String, String> uidAndNameForChange = new HashMap<>();
        for (String r : record) {
            String[] info = r.split(" ");
            String type = info[0]; // Enter, Leave, Change
            String uid = info[1];

            if (type.equals("Enter")) {
                String nickname = info[2];
                uidAndNameForChange.put(uid, nickname);
                enterLeaveLists.add(new Event(uid, "Enter"));
            } else if (type.equals("Leave")) {
                enterLeaveLists.add(new Event(uid, "Leave"));
            } else if (type.equals("Change")) {
                String nickname = info[2];
                uidAndNameForChange.put(uid, nickname);
            }

        }


        for (Event e : enterLeaveLists) {
            String uid = e.uid;
            String type = e.type;
            String name = uidAndNameForChange.get(uid);

            if (type.equals("Enter")) {
                resultList.add(name + "님이 들어왔습니다.");
            } else if (type.equals("Leave")) {
                resultList.add(name + "님이 나갔습니다.");
            }
        }

        System.out.println("resultList = " + resultList);


        return resultList.toArray(String[]::new);
    }
    public static void main(String[] args) {
        OpenChattingRoom problem = new OpenChattingRoom();
        String[] inputs = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(problem.solution(inputs));
    }
}

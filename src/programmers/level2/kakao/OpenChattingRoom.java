package programmers.level2.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OpenChattingRoom {

    // List -> list돌면서 다 확인..? 너무 무거워 지는거 아닌가?
    // 2개로 나눠서
    // 1. uid, name HashMap -> 최종이름만 반환
    // 2. Enter, Leave 와 uid를 저장하는 List
    // 3. 마지막에 Map 활용해서 list에 있는 uid 값을 치환하기
    public String[] solution(String[] record) {
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<String> enterLeaveLists = new ArrayList<>();
        HashMap<String, String> uidAndNameForChange = new HashMap<>();
        for (String r : record) {
            String[] info = r.split(" ");
            String type = info[0];
            String uid = info[1];
            String name;
            switch (type) {
                case "Enter":
                    name = info[2];
                    uidAndNameForChange.put(uid, name);
                    enterLeaveLists.add(uid + " " + type);
                    break;
                case "Leave":
                    enterLeaveLists.add(uid + " " + type);
                    break;
                case "Change":
                    name = info[2];
                    uidAndNameForChange.put(uid, name);
                    break;
            }
        }

        for (String enterLeave : enterLeaveLists) {
            String[] info = enterLeave.split(" ");
            String uid = info[0];
            String type = info[1];
            String name = uidAndNameForChange.get(uid);

            if (type.equals("Enter")) {
                resultList.add(name + "님이 들어왔습니다.");
            } else if (type.equals("Leave")) {
                resultList.add(name + "님이 나갔습니다.");
            }
        }


        return resultList.toArray(String[]::new);
    }
    public static void main(String[] args) {
        OpenChattingRoom problem = new OpenChattingRoom();
        String[] inputs = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(problem.solution(inputs));
    }
}

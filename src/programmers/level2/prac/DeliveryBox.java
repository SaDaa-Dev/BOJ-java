package programmers.level2.prac;

import java.util.*;

// 택배 상자
public class DeliveryBox {
    public int solution(int[] order) {
        // 4 3 1 2 => 1 2 3 보조, 4 넣고 3 넣고 병목 -> 2개만 싫기 가능
        // 100만의 입력 길이 -> 최소 O(N)의 시간복잡도를 가져야한다.
        ArrayDeque<Integer> mainBelt = new ArrayDeque<>();
        ArrayDeque<Integer> subBelt = new ArrayDeque<>();
        for (int i = 1; i <= order.length; i++) {
            mainBelt.add(i);
        }
        int target = 0;
        int answer = 0;
        for (int box : mainBelt) {
            int targetBoxNum = order[target];
            if (targetBoxNum == box) {
                answer++;
                target++;

                while (!subBelt.isEmpty() && subBelt.peek() == order[target]) {
                    subBelt.pop();
                    target++;
                    answer++;
                }
            } else {
                subBelt.push(box);
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        DeliveryBox problem = new DeliveryBox();
        System.out.println(problem.solution(new int[]{5,4,3,2,1}));

    }
}

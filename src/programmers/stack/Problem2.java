package programmers.stack;

import java.util.LinkedList;

public class Problem2 {
    public static void main(String[] args) {
        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};

        int[] result = solution(progresses, speeds);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> workDay = new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int processedNum = (int) Math.ceil((double)remainingWork / speeds[i]);
            workDay.add(processedNum);
        }
        // 7 3 9
        int beforeDoneWork = workDay.getFirst();
        int tmpSum = 1;
        for (int i = 1; i < workDay.size(); i++) {
            if (beforeDoneWork >= workDay.get(i)) { // 이전 작업이 더 오래 걸리면 함께 배포
                tmpSum++;
            } else { // 새로운 작업부터 다시 계산
                result.add(tmpSum);
                beforeDoneWork = workDay.get(i);
                tmpSum = 1;
            }
        }
        result.add(tmpSum);

        return result.stream().mapToInt(i -> i).toArray();
    }
}

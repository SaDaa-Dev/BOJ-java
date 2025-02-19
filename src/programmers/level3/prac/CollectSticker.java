package programmers.level3.prac;

public class CollectSticker {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if (len == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }

        return Math.max(dp1[len - 2], dp2[len - 1]);
    }

//    public int solution(int sticker[]) {
//        int answer = Integer.MIN_VALUE;
//        int n = sticker.length;
//        for (int i = 0; i < n; i++) {
//            Queue<Integer> queue = new LinkedList<>();
//            boolean[] visited = new boolean[n];
//            queue.offer(i);
//            int currentSum = 0;
//            if (i == n - 1) {
//                visited[0] = true;
//            } else {
//                visited[i + 1] = true;
//            }
//
//            if (i == 0) {
//                visited[n - 1] = true;
//            } else {
//                visited[i - 1] = true;
//            }
//
//            while (!queue.isEmpty()) {
//                Integer currentIdx = queue.poll();
//                currentSum += sticker[currentIdx];
//
//                if ((currentIdx + 2 < n) && !visited[currentIdx + 2]) {
//                    queue.offer(currentIdx + 2);
//                }
//            }
//
//            answer = Math.max(answer, currentSum);
//        }
//
//        return answer;
//    }
    public static void main(String[] args) {
        CollectSticker problem = new CollectSticker();
        int[] input = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println("problem.solution(input) = " + problem.solution(input));
        int[] input1 = {1, 3, 2, 5, 4};
        System.out.println("problem.solution(input) = " + problem.solution(input1));
    }
}

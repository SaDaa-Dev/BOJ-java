package programmers.level3.prac;

public class ExplodeBalloon {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        if (len == 2) {
            return len;
        }

        int[] leftMin = new int[len];
        int[] rightMin = new int[len];

        leftMin[0] = a[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                answer++;
            } else {
                if (a[i] <= leftMin[i - 1] || a[i] <= rightMin[i + 1]) {
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        ExplodeBalloon problem = new ExplodeBalloon();
        int[] a = {9, -1, -5};
        System.out.println(problem.solution(a));
        System.out.println(problem.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
}

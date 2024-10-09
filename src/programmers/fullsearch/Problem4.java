package programmers.fullsearch;

public class Problem4 {
    public static void main(String[] args) {
        int[] solution = solution(8, 1);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }


    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int h = 1; h < Math.sqrt(yellow); h++) {
            int w = yellow / h;
            if (2 * (w + h) + 4 == brown) {
                answer[0] = w + 2;
                answer[1] = h + 2;
                return answer;
            }
        }

        return answer;
    }
}

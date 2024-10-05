package programmers.fullsearch;
public class Problem1 {
    public static void main(String[] args) {
        int[][] input = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        System.out.println("result = " + solution(input));
    }

    private static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}

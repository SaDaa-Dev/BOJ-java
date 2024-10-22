package programmers.dfsbfs;

// 타겟 넘버
public class Problem1 {
    private int[] numbers;
    private int target;
    private int targetSum;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return targetSum;
    }

    public void dfs(int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) {
                targetSum++;
            }
            return;
        }

        dfs(index + 1, currentSum + numbers[index]);
        dfs(index + 1, currentSum - numbers[index]);
    }


    public static void main(String[] args) {
        Problem1 problem = new Problem1();

        problem.solution(new int[]{4,1,2,1}, 4);
    }

}

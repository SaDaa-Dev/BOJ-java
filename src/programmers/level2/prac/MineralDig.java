package programmers.level2.prac;

import java.util.ArrayList;
import java.util.List;

public class MineralDig {
    private int[][] fatigueTable = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
    };

    private int getFatigue(String mineral, int pickType) {
        switch (mineral) {
            case "diamond":
                return fatigueTable[pickType][0];
            case "iron":
                return fatigueTable[pickType][1];
            default:
                return fatigueTable[pickType][2];
        }

    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int digLimit = Math.min(totalPicks * 5, minerals.length);

        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < digLimit; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < digLimit ; j++) {
                String mineralType = minerals[j];
                if(mineralType.equals("diamond")) dia++;
                else if (mineralType.equals("iron")) iron++;
                else stone++;
            }
            int fatigue = dia * getFatigue("diamond", 2)
                    + iron * getFatigue("iron", 2)
                    + stone * getFatigue("stone", 2);

            groups.add(new int[]{fatigue, dia, iron, stone});
        }
        groups.sort(((o1, o2) -> Integer.compare(o2[0], o1[0])));

        for (int[] group : groups) {
            if (picks[0] > 0) {
                answer += group[1] + group[2] + group[3];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += (group[1] * 5) + group[2] + group[3];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += (group[1] * 25) + (group[2] * 5) + group[3];
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MineralDig problem = new MineralDig();
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(problem.solution(picks, minerals));
    }
}

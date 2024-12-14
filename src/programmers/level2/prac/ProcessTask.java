package programmers.level2.prac;

import java.util.*;

public class ProcessTask {
    private class Solution {
        private class Plan {
            String name;
            int startTime;
            int duration;

            public Plan(String name, String startTime, String duration) {
                this.name = name;
                this.startTime = convertHourToMinute(startTime);
                this.duration = Integer.parseInt(duration);
            }

            private int convertHourToMinute(String hourTime) {
                int[] hourWithMinute = Arrays.stream(hourTime.split(":")).mapToInt(Integer::parseInt).toArray();
                return (hourWithMinute[0] * 60) + hourWithMinute[1];
            }
        }
        public String[] solution(String[][] plans) {
            List<Plan> planList = new ArrayList<>();
            for (String[] plan : plans) {
                planList.add(new Plan(plan[0], plan[1], plan[2]));
            }

            Collections.sort(planList, Comparator.comparingInt(o1 -> o1.startTime));

            Deque<Plan> stack = new ArrayDeque<>();
            ArrayList<String> result = new ArrayList<>();
            int currentTime = 0;

            for (int i = 0; i < planList.size(); i++) {
                Plan currentPlan = planList.get(i);
                if (i == 0) {
                    currentTime = currentPlan.startTime;
                }

                currentTime = Math.max(currentTime, currentPlan.startTime);
                int endTime = currentTime + currentPlan.duration;

                if (i + 1 < planList.size()) {
                    Plan nextPlan = planList.get(i + 1);
                    if (endTime > nextPlan.startTime) { // 과제 중단
                        currentPlan.duration = endTime - nextPlan.startTime;
                        stack.push(currentPlan);
                        currentTime = nextPlan.startTime;
                    } else { // 과제 완료
                        result.add(currentPlan.name);
                        currentTime = endTime;

                        while (!stack.isEmpty() && i + 1 < planList.size()) {
                            Plan stopedPlan = stack.pop();
                            if (currentTime + stopedPlan.duration <= nextPlan.startTime) { // 중단된 작업 완료 가능
                                currentTime += stopedPlan.duration;
                                result.add(stopedPlan.name);
                            } else { // 남은 작업 완료 불가
                                stopedPlan.duration -= (nextPlan.startTime - currentTime);
                                stack.push(stopedPlan);
                                currentTime = nextPlan.startTime;
                                break;
                            }
                        }
                    }
                } else { // 마지막 과제
                    result.add(currentPlan.name);
                    while (!stack.isEmpty()) {
                        result.add(stack.pop().name);
                    }
                }
            }

            return result.toArray(new String[0]);
        }
    }
    public static void main(String[] args) {
        ProcessTask prom = new ProcessTask();
        Solution sol = prom.new Solution();
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(sol.solution(plans)));

    }
}

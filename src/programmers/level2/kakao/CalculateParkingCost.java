package programmers.level2.kakao;

import java.util.*;

public class CalculateParkingCost {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();
        for (String record : records) {
            String[] info = record.split(" ");
            int time = convertToMin(info[0]);
            String carNumber = info[1];

            if (map.containsKey(carNumber)) {
                Integer inTime = map.get(carNumber);
                int totalTime = time - inTime;
                resultMap.put(carNumber, resultMap.getOrDefault(carNumber, 0) + totalTime);
                map.remove(carNumber);
            } else {
                map.put(carNumber, time);
            }
        }

        if (!map.isEmpty()) {
            for (String carNumber : map.keySet()) {
                int inTime = map.get(carNumber);
                int outTime = convertToMin("23:59");
                resultMap.put(carNumber, resultMap.getOrDefault(carNumber, 0) + (outTime - inTime));
            }
        }

        List<String> carList = new ArrayList<>(resultMap.keySet());
        Collections.sort(carList);

        for (String car : carList) {
            int totalTime = resultMap.get(car);
            int fee = calculateParkFee(fees, totalTime);
            result.add(fee);
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int convertToMin(String s) {
        String[] splitTime = s.split(":");
        int minuteByHour = Integer.parseInt(splitTime[0]) * 60;
        int minute = Integer.parseInt(splitTime[1]);
        return minuteByHour + minute;
    }
    private int calculateParkFee(int[] fees, int parkTime) {
        int freeTime = fees[0];
        int primaryFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        if (parkTime <= freeTime) {
            return primaryFee;
        }
        return (int) (primaryFee + Math.ceil((double)(parkTime - freeTime) / unitTime) * unitFee);
    }


    public static void main(String[] args) {
        CalculateParkingCost problem = new CalculateParkingCost();
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(problem.solution(fees, records)));
    }
}

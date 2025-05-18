package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int quantity = Integer.parseInt(st.nextToken());
        List<Integer> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            houses.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(houses);

        int low = 1;
        int high = houses.get(n - 1) - houses.get(0);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (isInstallable(houses, mid, quantity)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isInstallable(List<Integer> houses, int dist, int need) {
        int cnt = 1;
        int lastPos = houses.get(0);

        for (int i = 1; i < houses.size(); i++) {
            int curr = houses.get(i);
            if (curr - lastPos >= dist) {    // dist 이상 떨어지면 설치
                cnt++;
                lastPos = curr;
            }
        }
        return cnt >= need;
    }
}

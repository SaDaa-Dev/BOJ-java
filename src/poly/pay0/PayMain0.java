package poly.pay0;

import java.util.HashMap;

public class PayMain0 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>() {{
            put("kakao", 5000);
            put("naver", 10000);
            put("bad", 15000);
        }};

        for (String str : map.keySet()) {
            PayService payService = new PayService(str, map.get(str));
            payService.pay();
        }

    }
}

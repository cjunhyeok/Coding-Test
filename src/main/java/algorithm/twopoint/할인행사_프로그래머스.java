package main.java.algorithm.twopoint;

import java.util.HashMap;
import java.util.Map;

public class 할인행사_프로그래머스 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            String product = want[i];
            int count = number[i];
            map.put(product, count);
        }

        // init window
        for (int i = 0; i <= 9; i++) {
            String product = discount[i];

            if (map.containsKey(product)) {
                Integer count = map.get(product);
                map.put(product, count - 1);
            }
        }

        boolean isAnswer = true;
        for (String s : map.keySet()) {
            Integer count = map.get(s);
            if (count > 0) {
                isAnswer = false;
                break;
            }
        }

        if (isAnswer) {
            answer++;
        }

        int left = 0;
        int right = 10;

        for (int i = right; i < discount.length; i++) {
            String nonDiscountValue = discount[left];
            String discountValue = discount[i];

            if (map.containsKey(nonDiscountValue)) {
                Integer count = map.get(nonDiscountValue);
                map.put(nonDiscountValue, count + 1);
            }

            if (map.containsKey(discountValue)) {
                Integer count = map.get(discountValue);
                map.put(discountValue, count - 1);
            }

            isAnswer = true;
            for (String s : map.keySet()) {
                Integer count = map.get(s);
                if (count > 0) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                answer++;
            }
            left++;
        }

        return answer;
    }
}

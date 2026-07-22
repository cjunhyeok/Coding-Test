package main.java.algorithm.twopoint.retry;

import java.util.HashMap;
import java.util.Map;

public class 할인행사_프로그래머스 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int length = want.length;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String product = want[i];
            int num = number[i];

            map.put(product, num);
        }

        for (int i = 0; i < 10; i++) {
            String product = discount[i];

            if (map.containsKey(product)) {
                Integer count = map.get(product);
                map.put(product, count - 1);
            }
        }

        boolean isCorrect = true;
        for (String key : map.keySet()) {
            Integer count = map.get(key);
            if (count > 0) {
                isCorrect = false;
            }
        }

        if (isCorrect) {
            answer++;
        }

        int left = 0;
        for (int right = 10; right < discount.length; right++) {
            String leftKey = discount[left];
            if (map.containsKey(leftKey)) {
                Integer count = map.get(leftKey);
                map.put(leftKey, count + 1);
            }

            String rightKey = discount[right];
            if (map.containsKey(rightKey)) {
                Integer value = map.get(rightKey);

                map.put(rightKey, value - 1);
            }

            isCorrect = true;
            for (String s : map.keySet()) {
                Integer count = map.get(s);

                if (count > 0) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                answer++;
            }

            left++;
        }

        return answer;
    }
}

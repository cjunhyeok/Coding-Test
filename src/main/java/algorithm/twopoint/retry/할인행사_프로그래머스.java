package main.java.algorithm.twopoint.retry;

import java.util.HashMap;
import java.util.Map;

public class 할인행사_프로그래머스 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        int length = want.length;

        for (int i = 0; i < length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            String key = discount[i];

            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, value - 1);
            }
        }

        boolean isAnswer = true;
        for (String s : map.keySet()) {
            Integer count = map.get(s);

            if (count > 0) {
                isAnswer = false;
            }
        }
        if (isAnswer) {
            answer++;
        }

        int left = 0;
        for (int right = 10; right < discount.length; right++) {

            String leftKey = discount[left];
            if (map.containsKey(leftKey)) {
                Integer value = map.get(leftKey);
                map.put(leftKey, value + 1);
            }

            String rightKey = discount[right];
            if (map.containsKey(rightKey)) {
                Integer value = map.get(rightKey);

                map.put(rightKey, value - 1);
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

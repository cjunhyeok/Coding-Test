package main.java.algorithm.twopoint;

import java.util.*;

public class 롤케이크자르기_프로그래머스 {
    public int solution(int[] topping) {
        int answer = 0;

        int totalToppingCount = topping.length;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        leftMap.put(topping[0], 1);
        for (int i = 1; i < totalToppingCount; i++) {
            int value = topping[i];
            if (rightMap.containsKey(value)) {
                rightMap.put(value, rightMap.get(value) + 1);
            } else {
                rightMap.put(value, 1);
            }
        }

        if (leftMap.size() == rightMap.size()) {
            answer++;
        }

        for (int i = 1; i < totalToppingCount; i++) {
            int value = topping[i];
            if (leftMap.containsKey(value)) {
                leftMap.put(value, leftMap.get(value) + 1);
            } else {
                leftMap.put(value, 1);
            }

            if (rightMap.containsKey(value)) {
                Integer count = rightMap.get(value);

                if (count == 1) {
                    rightMap.remove(value);
                } else {
                    rightMap.put(value, count - 1);
                }
            }

            if (leftMap.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}

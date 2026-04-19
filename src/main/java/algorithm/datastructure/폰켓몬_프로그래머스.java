package main.java.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬_프로그래머스 {

    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer value = map.get(num);
                map.put(num, value + 1);
            } else {
                map.put(num, 1);
            }
        }

        int divide = nums.length / 2;

        if (map.size() >= divide) {
            return divide;
        } else {
            return map.size();
        }
    }
}

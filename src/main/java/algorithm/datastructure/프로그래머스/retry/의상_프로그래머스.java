package main.java.algorithm.datastructure.프로그래머스.retry;

import java.util.HashMap;
import java.util.Map;

public class 의상_프로그래머스 {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String key = clothe[1];

            if (map.containsKey(key)) {
                Integer count = map.get(key);
                map.put(key, count + 1);
            } else {
                map.put(key, 1);
            }
        }

        answer = 1;
        for (String s : map.keySet()) {
            Integer count = map.get(s);

            answer = answer * (count + 1);
        }

        return answer - 1;
    }
}

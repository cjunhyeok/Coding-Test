package main.java.algorithm.datastructure.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 의상_프로그래머스 {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];

            if (map.containsKey(kind)) {
                Integer value = map.get(kind);
                map.put(kind, value + 1);
            } else {
                map.put(kind, 1);
            }
        }

        for (Integer value : map.values()) {
            answer = answer * (value + 1);
        }

        return answer - 1;
    }
}

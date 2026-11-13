package main.java.algorithm.datastructure.retry;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수_프로그래머스 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            if (map.containsKey(s)) {
                Integer count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s : completion) {
            Integer count = map.get(s);

            if (count != 0) {
                return s;
            }
        }

        return answer;
    }
}

package main.java.algorithm.datastructure.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수_프로그래머스 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participants = new HashMap<>();
        for (String part : participant) {
            if (participants.containsKey(part)) {
                Integer count = participants.get(part);
                participants.put(part, count + 1);
            } else {
                participants.put(part, 1);
            }
        }

        for (String comp : completion) {
            if (participants.containsKey(comp)) {
                Integer count = participants.get(comp);
                if (count - 1 == 0) {
                    participants.remove(comp);
                } else {
                    participants.put(comp, count - 1);
                }
            }
        }

        for (String s : participants.keySet()) {
            if (participants.containsKey(s)) {
                answer = s;
            }
        }

        return answer;
    }
}

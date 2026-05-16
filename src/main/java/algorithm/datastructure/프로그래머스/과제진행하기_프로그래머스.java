package main.java.algorithm.datastructure.프로그래머스;

import java.util.*;

public class 과제진행하기_프로그래머스 {
    static class Plan {
        String name;
        int start;
        int playTime;

        Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Plan> planList = new ArrayList<>();

        for (String[] plan : plans) {
            planList.add(new Plan(
                    plan[0],
                    toMinute(plan[1]),
                    Integer.parseInt(plan[2])
            ));
        }

        planList.sort(Comparator.comparingInt(p -> p.start));

        List<String> result = new ArrayList<>();
        Deque<Plan> paused = new ArrayDeque<>();

        for (int i = 0; i < planList.size() - 1; i++) {
            Plan current = planList.get(i);
            Plan next = planList.get(i + 1);

            int availableTime = next.start - current.start;

            if (current.playTime <= availableTime) {
                result.add(current.name);
                availableTime -= current.playTime;

                while (availableTime > 0 && !paused.isEmpty()) {
                    Plan prev = paused.pop();

                    if (prev.playTime <= availableTime) {
                        result.add(prev.name);
                        availableTime -= prev.playTime;
                    } else {
                        prev.playTime -= availableTime;
                        paused.push(prev);
                        break;
                    }
                }
            } else {
                current.playTime -= availableTime;
                paused.push(current);
            }
        }

        Plan last = planList.get(planList.size() - 1);
        result.add(last.name);

        while (!paused.isEmpty()) {
            result.add(paused.pop().name);
        }

        return result.toArray(new String[0]);
    }

    private int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}

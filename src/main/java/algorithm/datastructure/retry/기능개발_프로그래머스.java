package main.java.algorithm.datastructure.retry;

import java.util.*;

public class 기능개발_프로그래머스 {
    public List solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int length = progresses.length;
        if (length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        int firstProgress = progresses[0];
        int firstSpeed = speeds[0];

        int remain = 100 - firstProgress;
        int day = 0;

        if (remain % firstSpeed == 0) {
            day = remain / firstSpeed;
        } else {
            day = (remain / firstSpeed) + 1;
        }

        List<Integer> list = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int after = speed * day;

            if (progress + after >= 100) {
                count++;
            } else {
                list.add(count);
                count = 1;

                remain = 100 - progress;

                if (remain % speed == 0) {
                    day = remain / speed;
                } else {
                    day = (remain / speed) + 1;
                }
            }
        }

        list.add(count);

        return list;
    }
}

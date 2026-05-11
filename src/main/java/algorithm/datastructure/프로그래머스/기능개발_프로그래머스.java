package main.java.algorithm.datastructure.프로그래머스;

import java.util.*;

public class 기능개발_프로그래머스 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }

        int count = 0;
        int currentIndx = 0;

        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int speed = speeds[currentIndx];

            if (poll + (speed * count) < 100) {
                int time = 100 - poll;

                if (time % speed == 0) {
                    count = time / speed;
                } else {
                    count = (time / speed) + 1;
                }
            }

            currentIndx++;

            if (stack.isEmpty()) {
                stack.add(count);
                continue;
            }

            Integer peek = stack.peek();

            if (peek == count) {
                stack.add(count);
            } else {
                list.add(stack.size());
                stack = new Stack<>();
                stack.add(count);
            }
        }

        if (!stack.isEmpty()) {
            list.add(stack.size());
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

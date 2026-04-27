package main.java.algorithm.datastructure.프로그래머스;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class 프로세스_프로그래머스 {
    public int solution(int[] priorities, int location) {
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Integer[]{priorities[i], i});
        }

        Queue<Integer[]> resultQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer priority = poll[0];

            boolean isPriority = true;
            for (Integer[] integers : queue) {
                Integer value = integers[0];

                if (value > priority) {
                    isPriority = false;
                    break;
                }
            }

            if (isPriority) {
                resultQueue.add(poll);
            } else {
                queue.add(poll);
            }
        }

        int result = 1;
        while (!resultQueue.isEmpty()) {
            Integer[] poll = resultQueue.poll();
            Integer index = poll[1];

            if (Objects.equals(index, location)) {
                break;
            } else {
                result++;
            }
        }

        return result;
    }
}

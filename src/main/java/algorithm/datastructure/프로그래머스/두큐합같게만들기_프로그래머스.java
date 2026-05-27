package main.java.algorithm.datastructure.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기_프로그래머스 {

    public static void main(String[] args) {
        solution(new int[]{1, 1, 2}, new int[]{1, 1, 1});
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        long leftQueueCount = 0;
        Queue<Long> leftQueue = new LinkedList<>();
        for (int i : queue1) {
            leftQueue.add(Long.valueOf(i));
            leftQueueCount = leftQueueCount + i;
        }

        long rightQueueCount = 0;
        Queue<Long> rightQueue = new LinkedList<>();
        for (int i : queue2) {
            rightQueue.add(Long.valueOf(i));
            rightQueueCount = rightQueueCount + i;
        }

        if ((leftQueueCount + rightQueueCount) % 2 != 0) {
            return -1;
        }

        answer = 0;
        while (leftQueueCount != rightQueueCount) {

            if (leftQueue.isEmpty()) {
                return -1;
            }

            if (rightQueue.isEmpty()) {
                return -1;
            }

            if (answer >= queue1.length * 3) {
                return -1;
            }

            if (leftQueueCount < rightQueueCount) {
                Long poll = rightQueue.poll();
                rightQueueCount = rightQueueCount - poll;
                leftQueue.add(poll);
                leftQueueCount = leftQueueCount + poll;
            } else if (leftQueueCount > rightQueueCount) {
                Long poll = leftQueue.poll();
                leftQueueCount = leftQueueCount - poll;
                rightQueue.add(poll);
                rightQueueCount = rightQueueCount + poll;
            }

            answer++;
        }

        return answer;
    }
}

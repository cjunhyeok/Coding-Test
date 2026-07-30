package main.java.algorithm.datastructure.프로그래머스.retry;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기_프로그래머스 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> leftQueue = new LinkedList<>();
        long leftSum = 0l;
        for (int i = 0; i < queue1.length; i++) {
            int value = queue1[i];
            leftQueue.add(value);
            leftSum += value;
        }

        Queue<Integer> rightQueue = new LinkedList<>();
        long rightSum = 0;
        for (int i = 0; i < queue2.length; i++) {
            int value = queue2[i];
            rightQueue.add(value);
            rightSum += value;
        }

        long target = (leftSum + rightSum) / 2;
        int limit = queue1.length * 4;

        int loop = 0;
        while (true) {

            if (loop == limit) {
                return -1;
            }

            if (leftSum == rightSum) {
                if (leftSum == target) {
                    break;
                }
                return -1;
            }

            if (leftSum < target) {
                if (rightQueue.isEmpty()) {
                    return -1;
                }

                Integer poll = rightQueue.poll();
                rightSum -= poll;
                leftQueue.add(poll);
                leftSum += poll;
            } else if (leftSum > target) {
                if (leftQueue.isEmpty()) {
                    return -1;
                }

                Integer poll = leftQueue.poll();
                leftSum -= poll;
                rightQueue.add(poll);
                rightSum += poll;
            }
            loop++;
            answer++;
        }

        return answer;
    }
}

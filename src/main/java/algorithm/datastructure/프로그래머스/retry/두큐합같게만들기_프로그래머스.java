package main.java.algorithm.datastructure.프로그래머스.retry;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기_프로그래머스 {
    public int solution(int[] queue1, int[] queue2) {

        Queue<Long> leftQueue = new LinkedList<>();
        Queue<Long> rightQueue = new LinkedList<>();
        long leftSum = 0;
        long rightSum = 0;
        for (int i = 0; i < queue1.length; i++) {
            int left = queue1[i];
            leftQueue.add(Long.valueOf(left));
            leftSum = leftSum + left;

            int right = queue2[i];
            rightQueue.add(Long.valueOf(right));
            rightSum = rightSum + right;
        }

        if ((leftSum + rightSum) % 2 != 0) {
            return -1;
        }

        int totalLoopCount = 4 * queue1.length;
        int answer = 0;

        while (leftSum != rightSum) {

            if (answer >= totalLoopCount) {
                return -1;
            }

            if (leftQueue.isEmpty()) {
                return -1;
            }

            if (rightQueue.isEmpty()) {
                return -1;
            }

            if (leftSum > rightSum) {
                Long poll = leftQueue.poll();
                leftSum = leftSum - poll;
                rightQueue.add(poll);
                rightSum = rightSum + poll;
            } else if (leftSum < rightSum){
                Long poll = rightQueue.poll();
                rightSum = rightSum - poll;
                leftQueue.add(poll);
                leftSum = leftSum + poll;
            }

            answer++;
        }

        return answer;
    }
}

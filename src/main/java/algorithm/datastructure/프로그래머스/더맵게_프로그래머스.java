package main.java.algorithm.datastructure.프로그래머스;

import java.util.PriorityQueue;

public class 더맵게_프로그래머스 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i : scoville) {
            priorityQueue.add(Integer.toUnsignedLong(i));
        }

        boolean isK = false;

        while (true) {

            if (priorityQueue.isEmpty()) {
                break;
            }

            Long peek = priorityQueue.peek();
            if (peek >= K) {
                isK = true;
                break;
            }

            Long first = priorityQueue.poll();

            if (priorityQueue.isEmpty()) {
                break;
            }
            Long second = priorityQueue.poll();

            Long food = first + (second * 2);
            priorityQueue.add(food);
            answer++;
        }

        if (!isK) {
            return -1;
        }

        return answer;
    }
}

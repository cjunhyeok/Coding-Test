package main.java.algorithm.datastructure.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭_프로그래머스 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            queue.add(truckWeight);
        }

        int currentWeight = 0;

        Queue<Integer> bridge = new LinkedList<>();
        while (!queue.isEmpty()) {

            if (bridge.isEmpty()) {
                Integer poll = queue.poll();
                bridge.add(poll);
                currentWeight = currentWeight + poll;
                time++;
                continue;
            }

            Integer currentTruck = queue.peek();

            if (bridge.size() == bridge_length) {
                Integer poll = bridge.poll();
                currentWeight = currentWeight - poll;

                int nextWeight = currentWeight + currentTruck;

                if (nextWeight <= weight) {
                    currentTruck = queue.poll();
                    bridge.add(currentTruck);
                    currentWeight = nextWeight;
                    time++;
                } else {
                    bridge.add(0);
                    time++;
                }
            } else {

                int nextWeight = currentWeight + currentTruck;

                if (nextWeight <= weight) {
                    currentTruck = queue.poll();
                    bridge.add(currentTruck);
                    currentWeight = nextWeight;
                    time++;
                } else {
                    bridge.add(0);
                    time++;
                }
            }
        }

        if (bridge.size() < bridge_length) {
            int size = bridge.size();
            for (int i = 0; i < bridge_length - size; i++) {
                bridge.add(0);
                time++;
            }
        }

        int count = 0;
        while (!bridge.isEmpty()) {
            Integer poll = bridge.poll();
            count++;

            if (poll != 0) {
                time = time + count;
                count = 0;
            }
        }

        return time;
    }
}

package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> waitQueue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();
        Integer lastTruck = -1;

        line = br.readLine();
        st = new StringTokenizer(line, " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            waitQueue.add(value);

            if (i == N - 1) {
                lastTruck = value;
            }
        }

        int onBridgeWeight = 0;

        Integer result = 0;

        while (true) {

            int trucksOnBridgeCount = bridgeQueue.size();

            if (trucksOnBridgeCount < W) {

                int nextOnBridgeWeight = onBridgeWeight;
                if (!waitQueue.isEmpty()) {
                    Integer waitTruck = waitQueue.peek();
                    nextOnBridgeWeight = waitTruck + onBridgeWeight;
                }

                if (nextOnBridgeWeight <= L) {

                    if (!waitQueue.isEmpty()) {
                        Integer poll = waitQueue.poll();
                        bridgeQueue.add(poll);
                        onBridgeWeight = onBridgeWeight + poll;
                        result++;
                    } else {
                        bridgeQueue.add(0);
                        result++;
                    }

                } else {
                    bridgeQueue.add(0);
                    result++;
                }

            } else if (trucksOnBridgeCount == W) {
                Integer poll = bridgeQueue.poll();
                onBridgeWeight = onBridgeWeight - poll;

                if (Objects.equals(poll, lastTruck)) {
                    result++;
                    break;
                }

                int nextOnBridgeWeight = onBridgeWeight;
                if (!waitQueue.isEmpty()) {
                    Integer waitTruck = waitQueue.peek();
                    nextOnBridgeWeight = waitTruck + onBridgeWeight;
                }

                if (nextOnBridgeWeight <= L) {

                    if (!waitQueue.isEmpty()){
                        poll = waitQueue.poll();
                        bridgeQueue.add(poll);
                        onBridgeWeight = onBridgeWeight + poll;
                        result++;
                    } else {
                        bridgeQueue.add(0);
                        result++;
                    }

                } else {
                    bridgeQueue.add(0);
                    result++;
                }
            }
        }

        while (!bridgeQueue.isEmpty()) {
            Integer poll = bridgeQueue.poll();

            if (!Objects.equals(poll, 0)) {
                result++;
            }
        }

        System.out.println(result );
    }
}

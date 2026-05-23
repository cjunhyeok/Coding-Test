package main.java.algorithm.greedy;

import java.util.Stack;

public class 택배배달과수거하기_프로그래머스 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> delStack = new Stack<>();
        Stack<Integer> pickStack = new Stack<>();
        for (int i  = 0; i < n; i++) {
            int delivery = deliveries[i];
            int pickup = pickups[i];

            delStack.add(delivery);
            pickStack.add(pickup);
        }

        while (true) {
            if (delStack.isEmpty()) {
                break;
            }
            Integer peek = delStack.peek();
            if (peek != 0) {
                break;
            }
            delStack.pop();
        }

        while (true) {
            if (pickStack.isEmpty()) {
                break;
            }
            Integer peek = pickStack.peek();
            if (peek != 0) {
                break;
            }
            pickStack.pop();
        }

        while (!delStack.isEmpty() || !pickStack.isEmpty()) {
            int pickCap = cap;

            int currentMaxSize = Math.max(delStack.size(), pickStack.size());
            answer = answer + (currentMaxSize * 2);

            int delCap = cap;
            while (delCap > 0) {
                if (delStack.isEmpty()) {
                    break;
                }

                Integer delPick = delStack.peek();
                if (delPick == delCap) {
                    delCap = 0;
                    delStack.pop();
                } else if (delPick < delCap) {
                    delCap = delCap - delPick;
                    delStack.pop();
                } else {
                    Integer pop = delStack.pop();
                    delStack.push(pop - delCap);
                    delCap = 0;
                }
            }

            while (pickCap > 0) {
                if (pickStack.isEmpty()) {
                    break;
                }
                Integer pickPeek = pickStack.peek();

                if (pickPeek == pickCap) {
                    pickCap = 0;
                    pickStack.pop();
                } else if (pickPeek < pickCap) {
                    pickCap = pickCap - pickPeek;
                    pickStack.pop();
                } else {
                    Integer pop = pickStack.pop();
                    pickStack.push(pop - pickCap);
                    pickCap = 0;
                }
            }

            while (true) {
                if (delStack.isEmpty()) {
                    break;
                }
                Integer peek = delStack.peek();
                if (peek != 0) {
                    break;
                }
                delStack.pop();
            }

            while (true) {
                if (pickStack.isEmpty()) {
                    break;
                }
                Integer peek = pickStack.peek();
                if (peek != 0) {
                    break;
                }
                pickStack.pop();
            }
        }

        return answer;
    }
}

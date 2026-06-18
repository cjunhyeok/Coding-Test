package main.java.algorithm.greedy.retry;

import java.util.Stack;

public class 택배배달과수거하기_프로그래머스 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> delStack = new Stack<>();
        for (int delivery : deliveries) {
            delStack.add(delivery);
        }
        while (!delStack.isEmpty()) {
            Integer peek = delStack.peek();
            if (peek.equals(0)) {
                delStack.pop();
            } else {
                break;
            }
        }

        Stack<Integer> pickStack = new Stack<>();
        for (int pickup : pickups) {
            pickStack.add(pickup);
        }
        while (!pickStack.isEmpty()) {
            Integer peek = pickStack.peek();
            if (peek.equals(0)) {
                pickStack.pop();
            } else {
                break;
            }
        }

        while (!delStack.isEmpty() || !pickStack.isEmpty()) {
            int delCap = cap;
            int pickCap = cap;

            int delSize = delStack.size();
            int pickSize = pickStack.size();

            answer = answer + (Math.max(delSize, pickSize) * 2);

            while (!delStack.isEmpty() && delCap > 0) {
                Integer pop = delStack.pop();

                if (pop > delCap) {
                    pop = pop - delCap;
                    delStack.add(pop);
                    delCap = 0;
                } else if (pop == delCap) {
                    delCap = 0;
                } else {
                    delCap = delCap - pop;
                }
            }

            while (!delStack.isEmpty()) {
                Integer peek = delStack.peek();
                if (peek.equals(0)) {
                    delStack.pop();
                } else {
                    break;
                }
            }

            while (!pickStack.isEmpty() && pickCap > 0) {

                Integer pop = pickStack.pop();

                if (pop > pickCap) {
                    pop = pop - pickCap;
                    pickStack.add(pop);
                    pickCap = 0;
                } else if (pop == pickCap) {
                    pickCap = 0;
                } else {
                    pickCap = pickCap - pop;
                }

                while (!pickStack.isEmpty()) {
                    Integer peek = pickStack.peek();
                    if (peek.equals(0)) {
                        pickStack.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        return answer;
    }
}

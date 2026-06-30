package main.java.algorithm;

import java.util.Stack;

public class 택배상자_프로그래머스 {

    public static void main(String[] args) {
        solution(new int[]{5, 4, 3, 2, 1});
    }

    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int start = 1;
        int index = 0;

        while (true) {

            if (index == order.length) {
                break;
            }

            int orderValue = order[index];

            if (start == orderValue) {
                answer++;
                index++;
                start++;
            } else if (start < orderValue) {
                stack.add(start);
                start++;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Integer pop = stack.pop();
                if (pop == orderValue) {
                    answer++;
                    index++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}

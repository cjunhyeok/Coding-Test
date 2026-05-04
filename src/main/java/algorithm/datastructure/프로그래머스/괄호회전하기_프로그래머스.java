package main.java.algorithm.datastructure.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기_프로그래머스 {

    public int solution(String s) {
        int answer = 0;

        int length = s.length();

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < length; i++) {
            Character poll = queue.poll();
            queue.add(poll);

            Stack<Character> stack = new Stack<>();

            boolean isCorrect = true;

            for (int j = 0; j < length; j++) {

                poll = queue.poll();

                if (stack.isEmpty()) {

                    if (poll.equals(')') || poll.equals(']') || poll.equals('}')) {
                        isCorrect = false;
                        queue.add(poll);
                        continue;
                    }

                    stack.add(poll);
                    queue.add(poll);
                    continue;
                }

                if (poll.equals('(') || poll.equals('[') || poll.equals('{')) {
                    stack.add(poll);
                } else if (poll.equals(')')){
                    Character peek = stack.peek();

                    if (peek.equals('(')) {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        queue.add(poll);
                        continue;
                    }
                } else if (poll.equals(']')) {
                    Character peek = stack.peek();

                    if (peek.equals('[')) {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        queue.add(poll);
                        continue;
                    }
                } else if (poll.equals('}')) {
                    Character peek = stack.peek();

                    if (peek.equals('{')) {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        queue.add(poll);
                        continue;
                    }
                }

                queue.add(poll);

            }

            if (!stack.isEmpty()) {
                isCorrect = false;
            }

            if (isCorrect) {
                answer++;
            }
        }

        return answer;
    }
}

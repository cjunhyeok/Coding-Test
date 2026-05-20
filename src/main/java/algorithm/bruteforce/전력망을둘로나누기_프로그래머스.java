package main.java.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을둘로나누기_프로그래머스 {

    private static int N;
    private static List<Integer>[] list;
    private static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        N = n;
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            int start = wire[0];
            int end = wire[1];

            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            int removeStart = wire[0];
            int removeEnd = wire[1];
            visited = new boolean[N + 1];

            List<Integer> answers = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    List<Integer> integers = list[removeStart];
                    for (int k = 0; k < integers.size(); k++) {
                        Integer value = integers.get(k);
                        if (value.equals(removeEnd)) {
                            list[removeStart].remove(k);
                        }
                    }
                    integers = list[removeEnd];
                    for (int k = 0; k < integers.size(); k++) {
                        Integer value = integers.get(k);
                        if (value.equals(removeStart)) {
                            list[removeEnd].remove(k);
                        }
                    }

                    int count = bfs(j);
                    answers.add(count);

                    list[removeStart].add(removeEnd);
                    list[removeEnd].add(removeStart);
                }
            }

            int currentAnswer = Math.abs(answers.get(0) - answers.get(1));

            answer = Math.min(answer, currentAnswer);
        }

        return answer;
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            List<Integer> integers = list[current];
            for (Integer value : integers) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                    count++;
                }
            }
        }

        return count;
    }

}

package main.java.algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 네트워크_프로그래머스 {

    private static int N;
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int result = 0;

    public int solution(int n, int[][] computers) {

        N = computers.length;
        list = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                result++;
            }
        }

        return result;
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            List<Integer> integers = list[poll];
            for (Integer value : integers) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }
}

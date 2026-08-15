package main.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 순위_프로그래머스 {

    private static int N;
    private static List<Integer>[] forwardList;
    private static List<Integer>[] reverseList;
    private static boolean[] visited;

    public int solution(int n, int[][] results) {
        int answer = 0;

        N = n;
        forwardList = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            forwardList[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < results.length; i++) {
            int[] result = results[i];
            int start = result[0];
            int end = result[1];

            forwardList[start].add(end);
            reverseList[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            forwardDfs(i);
            reverseDfs(i);

            boolean canRank = true;

            for (int v = 1; v <= N; v++) {
                if (!visited[v]) {
                    canRank = false;
                }
            }

            if (canRank) {
                answer++;
            }
        }

        return answer;
    }

    private static void forwardDfs(int start) {
        visited[start] = true;
        List<Integer> forwards = forwardList[start];

        for (int i = 0; i < forwards.size(); i++) {
            Integer forward = forwards.get(i);

            if (!visited[forward]) {
                forwardDfs(forward);
            }
        }
    }

    private static void reverseDfs(int start) {
        visited[start] = true;
        List<Integer> reverses = reverseList[start];

        for (int i = 0; i < reverses.size(); i++) {
            Integer reverse = reverses.get(i);

            if (!visited[reverse]) {
                reverseDfs(reverse);
            }
        }
    }
}

package main.java.algorithm.dfsbfs.retry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로_프로그래머스 {

    private static int N;
    private static boolean[] used;
    private static boolean found = false;
    private static List<String> path = new ArrayList<>();
    private static String[] answer;

    public String[] solution(String[][] tickets) {

        N = tickets.length;
        used = new boolean[N];
        answer = new String[N];

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        path.add("ICN");
        dfs("ICN", tickets);

        return answer;
    }

    private static void dfs(String current, String[][] tickets) {
        if (found) {
            return;
        }

        if (path.size() == N + 1) {
            answer = path.toArray(new String[0]);
            found = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }

            String[] ticket = tickets[i];
            String start = ticket[0];
            String end = ticket[1];

            if (!current.equals(start)) {
               continue;
            }

            used[i] = true;
            path.add(end);

            dfs(end, tickets);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

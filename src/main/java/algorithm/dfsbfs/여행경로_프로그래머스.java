package main.java.algorithm.dfsbfs;

import java.util.*;

public class 여행경로_프로그래머스 {

    private String[] answer;
    private boolean[] used;
    private boolean found = false;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        used = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", 0, tickets, path);

        return answer;
    }

    private void dfs(String current, int usedCount, String[][] tickets, List<String> path) {
        if (found) {
            return;
        }

        if (usedCount == tickets.length) {
            answer = path.toArray(new String[0]);
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i]) {
                continue;
            }

            if (!tickets[i][0].equals(current)) {
                continue;
            }

            used[i] = true;
            path.add(tickets[i][1]);

            dfs(tickets[i][1], usedCount + 1, tickets, path);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

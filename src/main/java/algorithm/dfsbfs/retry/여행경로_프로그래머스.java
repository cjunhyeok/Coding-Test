package main.java.algorithm.dfsbfs.retry;

import java.util.*;

public class 여행경로_프로그래머스 {

    private static int N;
    private static String[] answer;
    private static boolean[] visited;
    private static boolean isCorrect = false;

    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new String[N + 1];
        visited = new boolean[N];

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        List<String> resultList = new ArrayList<>();
        resultList.add("ICN");
        dfs("ICN", tickets, resultList);

        return answer;
    }

    private static void dfs(String start, String[][] tickets, List<String> resultList) {
        if (isCorrect) {
            return;
        }

        if (resultList.size() == N + 1) {
            isCorrect = true;
            answer = resultList.toArray(new String[0]);
            return;
        }

        for (int i = 0; i < N; i++) {
            String[] ticket = tickets[i];
            String ticketStart = ticket[0];
            String ticketEnd = ticket[1];

            if (!start.equals(ticketStart)) {
                continue;
            }

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            resultList.add(ticketEnd);
            dfs(ticketEnd, tickets, resultList);

            resultList.remove(resultList.size() - 1);
            visited[i] = false;
        }
    }
}

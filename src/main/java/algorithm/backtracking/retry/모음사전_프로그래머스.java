package main.java.algorithm.backtracking.retry;

public class 모음사전_프로그래머스 {

    private static int count = 0;
    private static int answer = 0;
    private static String[] values = new String[]{"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private static void dfs(String start, String target) {
        if (start.equals(target)) {
            answer = count;
            return;
        }

        if (start.length() == 5) {
            return;
        }

        for (String value : values) {
            count++;
            dfs(start + value, target);

            if (answer != 0) {
                return;
            }
        }
    }
}

package main.java.algorithm.backtracking.retry;

public class 모음사전_프로그래머스 {

    private static String[] values = new String[]{"A", "E", "I", "O", "U"};
    private static int count = 0;
    private static int answer = 0;

    public int solution(String word) {
        answer = 0;

        dfs("", word);

        return answer;
    }

    private static void dfs(String current, String target) {
        if (current.equals(target)) {
            answer = count;
            return;
        }

        if (current.length() == 5) {
            return;
        }

        for (String value : values) {
            count++;
            dfs(current + value, target);
        }
    }
}

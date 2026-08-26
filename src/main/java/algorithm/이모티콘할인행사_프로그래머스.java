package main.java.algorithm;

public class 이모티콘할인행사_프로그래머스 {

    private static int N;
    private static int[] path;
    private static boolean[] visited;
    private static int[][] USERS;
    private static int[] EMOTICONS;
    private static final int[] DISCOUNT = new int[]{10, 20, 30, 40};
    private static int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {

        N = emoticons.length;
        USERS = users;
        EMOTICONS = emoticons;
        path = new int[N];
        visited = new boolean[N];

        dfs(0);

        return answer;
    }

    private static void dfs(int depth) {
        if (depth == N) {
            // how to calculate?

            int currentUsersTotal = 0;
            int currentPlustCount = 0;

            for (int[] user : USERS) {
                int discountStandard = user[0];
                int costStandard = user[1];
                int currentUserTotal = 0;

                for (int i = 0; i < path.length; i++) {
                    int discount = path[i];
                    int emoticon = EMOTICONS[i];

                    if (discount >= discountStandard) {
                        int cost = emoticon * (100 - discount) / 100;
                        currentUserTotal += cost;
                    }
                }

                if (currentUserTotal >= costStandard) {
                    currentPlustCount++;
                } else {
                    currentUsersTotal += currentUserTotal;
                }
            }

            if (currentPlustCount > answer[0]) {
                answer = new int[]{currentPlustCount, currentUsersTotal};
            } else if (currentPlustCount == answer[0]) {
                if (currentUsersTotal > answer[1]) {
                    answer = new int[]{currentPlustCount, currentUsersTotal};
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!visited[depth]) {
                visited[depth] = true;
                path[depth] = DISCOUNT[i];
                dfs(depth + 1);
                visited[depth] = false;
            }
        }
    }
}

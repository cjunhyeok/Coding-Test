package main.java.algorithm;

public class 이모티콘할인행사_프로그래머스 {

    private static int[] selected;
    private static int[][] USERS;
    private static int[] EMOTICONS;
    private static int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        selected = new int[emoticons.length];

        USERS = users;
        EMOTICONS = emoticons;

        dfs(0);

        return answer;
    }

    private static void dfs(int depth) {
        if (depth == EMOTICONS.length) {
            calculate();
            return;
        }

        for (int discount : new int[]{10, 20, 30, 40}) {
            selected[depth] = discount;
            dfs(depth + 1);
        }
    }

    private static void calculate() {

        int totalPrice = 0;
        int plusCount = 0;

        for (int[] user : USERS) {
            int percent = user[0];
            int limit = user[1];

            int cost = 0;

            for (int i = 0; i < selected.length; i++) {
                int discount = selected[i];

                if (discount >= percent) {
                    int price = EMOTICONS[i] * (100 - discount) / 100;
                    cost += price;
                }
            }

            if (cost >= limit) {
                plusCount++;
            } else {
                totalPrice += cost;
            }
        }

        if (plusCount > answer[0]) {
            answer = new int[]{plusCount, totalPrice};
        } else if (plusCount == answer[0] && totalPrice > answer[1]) {
            answer = new int[]{plusCount, totalPrice};
        }
    }
}

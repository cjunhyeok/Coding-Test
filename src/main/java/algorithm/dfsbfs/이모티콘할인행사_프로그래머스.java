package main.java.algorithm.dfsbfs;

public class 이모티콘할인행사_프로그래머스 {

    private static int N;
    private static int[][] USERS;
    private static int[] EMOTICONS;
    private static int[] PATH;
    private static int[] DISCOUNTS = new int[]{10, 20, 30, 40};
    private static int[] answer = new int[]{0, 0};

    public int[] solution(int[][] users, int[] emoticons) {

        N = emoticons.length;
        USERS = users;
        EMOTICONS = emoticons;
        PATH = new int[N];

        dfs(0);

        return answer;
    }

    private static void dfs(int depth) {
        if (depth == N) {

            int emoticonPrice = 0;
            int plusCount = 0;

            for (int i = 0; i < USERS.length; i++) {
                int[] user = USERS[i];
                int standardDiscount = user[0];
                int standardPrice = user[1];

                int totalPrice = 0;

                for (int j = 0; j < N; j++) {
                    int discount = PATH[j];
                    int emoticon = EMOTICONS[j];

                    if (discount >= standardDiscount) {
                        int price = emoticon * (100 - discount) / 100;
                        totalPrice += price;
                    }
                }

                if (totalPrice >= standardPrice) {
                    plusCount++;
                } else {
                    emoticonPrice += totalPrice;
                }
            }

            if (plusCount > answer[0]) {
                answer = new int[]{plusCount, emoticonPrice};
            } else if (plusCount == answer[0]) {
                if (emoticonPrice > answer[1]) {
                    answer = new int[]{plusCount, emoticonPrice};
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            PATH[depth] = DISCOUNTS[i];
            dfs(depth + 1);
        }
    }
}

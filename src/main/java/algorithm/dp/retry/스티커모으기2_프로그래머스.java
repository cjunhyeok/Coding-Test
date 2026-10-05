package main.java.algorithm.dp.retry;

public class 스티커모으기2_프로그래머스 {
    public int solution(int sticker[]) {
        int answer = 0;

        int length = sticker.length;
        int[] first = new int[length];
        int[] second = new int[length];

        if (length == 1) {
            return sticker[0];
        }

        if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        if (length == 3) {
            int dp1 = Math.max(sticker[0], sticker[1]);

            return Math.max(sticker[2] + sticker[0], dp1);
        }


        first[0] = sticker[0];
        first[1] = Math.max(sticker[0], sticker[1]);
        first[2] = Math.max(first[1], sticker[2] + first[0]);
        for (int i = 3; i < length - 1; i++) {
            first[i] = Math.max(first[i - 1], sticker[i] + first[i - 2]);
            first[i] = Math.max(first[i], sticker[i] + first[i - 3]);

            answer = Math.max(answer, first[i]);
        }

        second[1] = sticker[1];
        second[2] = Math.max(sticker[1], sticker[2]);
        second[3] = Math.max(sticker[3], sticker[3] + second[1]);
        for (int i = 4; i < length; i++) {
            second[i] = Math.max(second[i - 1], sticker[i] + second[i - 2]);

            answer = Math.max(answer, second[i]);
        }

        return answer;
    }
}

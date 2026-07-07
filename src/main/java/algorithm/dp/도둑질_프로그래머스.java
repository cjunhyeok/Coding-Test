package main.java.algorithm.dp;

public class 도둑질_프로그래머스 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 1});
    }

    public static int solution(int[] money) {
        int[] first = new int[money.length];
        int[] second = new int[money.length];

        first[0] = money[0];
        first[1] = Math.max(money[1], money[0]);

        int answer = 0;
        for (int i = 2; i < money.length - 1; i++) {
            first[i] = Math.max(money[i] + first[i - 2], first[i - 1]);
            answer = Math.max(answer, first[i]);
        }

        second[1] = money[1];
        second[2] = Math.max(money[1], money[2]);

        for (int i = 3; i < money.length; i++) {
            second[i] = Math.max(money[i] + second[i - 2], second[i - 1]);
            answer = Math.max(answer, second[i]);
        }

        return answer;
    }
}

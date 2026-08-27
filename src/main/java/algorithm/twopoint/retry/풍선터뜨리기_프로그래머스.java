package main.java.algorithm.twopoint.retry;

public class 풍선터뜨리기_프로그래머스 {

    public static void main(String[] args) {
        solution(new int[]{9, -1, -5});
    }

    public static int solution(int[] a) {
        int answer = 0;

        int length = a.length;
        int[] leftMin = new int[length];
        int[] rightMin = new int[length];

        if (length == 1 || length == 2) {
            return length;
        }

        leftMin[0] = a[0];
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[length - 1] = a[length - 1];
        for (int i = length - 2; i >=0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        for (int i = 1; i < length - 1; i++) {
            if (a[i] > leftMin[i - 1] && a[i] > rightMin[i + 1]) {
                continue;
            }

            answer++;
        }

        return answer + 2;
    }
}

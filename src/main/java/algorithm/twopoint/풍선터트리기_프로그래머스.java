package main.java.algorithm.twopoint;

public class 풍선터트리기_프로그래머스 {
    public int solution(int[] a) {
        int answer = 0;
        int length = a.length;

        if (length == 1) {
            return 1;
        }

        int[] leftMin = new int[length];
        leftMin[0] = a[0];
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        int[] rightMin = new int[length];
        rightMin[length - 1] = a[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        for (int i = 1; i < length - 1; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer + 2;
    }
}

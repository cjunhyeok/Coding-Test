package main.java.algorithm.twopoint;

public class 연속펄스부분수열의합_프로그래머스 {

    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] pulse1 = new long[n];
        long[] pulse2 = new long[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                pulse1[i] = sequence[i];
                pulse2[i] = -sequence[i];
            } else {
                pulse1[i] = -sequence[i];
                pulse2[i] = sequence[i];
            }
        }

        return Math.max(kadane(pulse1), kadane(pulse2));
    }

    private long kadane(long[] arr) {
        long current = arr[0];
        long answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            answer = Math.max(answer, current);
        }

        return answer;
    }
}

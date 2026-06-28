package main.java.algorithm.twopoint.retry;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;

        int N = sequence.length;
        long[] firstSequence = new long[N];
        long[] secondSequence = new long[N];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                firstSequence[i] = sequence[i] * -1;
                secondSequence[i] = sequence[i];
            } else {
                firstSequence[i] = sequence[i];
                secondSequence[i] = sequence[i] * -1;
            }
        }

        long[] firstDp = new long[N];
        long[] secondDp = new long[N];

        firstDp[0] = firstSequence[0];
        secondDp[0] = secondSequence[0];

        answer = Math.max(answer, firstDp[0]);
        answer = Math.max(answer, secondDp[0]);

        for (int i = 1; i < N; i++) {
            long firstSequenceValue = firstSequence[i];
            long prevFirstDp = firstDp[i - 1];

            firstDp[i] = Math.max(firstSequenceValue, firstSequenceValue + prevFirstDp);

            long secondSequenceValue = secondSequence[i];
            long prevSecondDp = secondDp[i - 1];
            secondDp[i] = Math.max(secondSequenceValue, secondSequenceValue + prevSecondDp);

            answer = Math.max(answer, firstDp[i]);
            answer = Math.max(answer, secondDp[i]);
        }

        return answer;
    }
}

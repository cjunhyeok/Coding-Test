package main.java.algorithm.twopoint.retry;

public class 연속된부분수열의합_프로그래머스 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int N = sequence.length;

        int leftIndex = 0;
        int rightIndex = 0;
        int sum = sequence[0];

        int currentAnswerLength = Integer.MAX_VALUE;

        while (leftIndex < N) {

            if (sum == k) {
                int length = rightIndex - leftIndex;
                if (length < currentAnswerLength) {
                    currentAnswerLength = length;
                    answer = new int[]{leftIndex, rightIndex};
                    if (rightIndex < N - 1) {
                        rightIndex++;
                        sum = sum + sequence[rightIndex];
                    } else {
                        break;
                    }
                } else {
                    if (rightIndex < N - 1) {
                        rightIndex++;
                        sum = sum + sequence[rightIndex];
                    } else {
                        break;
                    }
                }
            } else if (sum < k) {

                if (rightIndex == N - 1) {
                    break;
                }

                rightIndex++;
                sum = sum + sequence[rightIndex];
            } else {
                sum = sum - sequence[leftIndex];
                leftIndex++;
            }
        }

        return answer;
    }
}

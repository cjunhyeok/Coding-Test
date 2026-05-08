package main.java.algorithm.twopoint;

public class 연속된부분수열의합_프로그래머스 {

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int currentResultLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int currentSum = sequence[0];

        while (left < sequence.length) {

            if (right == sequence.length - 1) {
                if (currentSum < k) {
                    break;
                }
            }

            if (left == right) {
                int value = sequence[left];
                if (value == k) {
                    currentResultLength = 1;
                    answer = new int[]{left, right};
                    break;
                } else if (value < k) {
                    right++;
                    currentSum = currentSum + sequence[right];
                } else if (value > k) {
                    currentSum = currentSum - sequence[left];
                    left++;
                }
            } else {

                if (currentSum == k) {
                    int length = right - left;
                    if (length < currentResultLength) {
                        answer = new int[]{left, right};
                        currentResultLength = length;
                    }

                    currentSum = currentSum - sequence[left];
                    left++;

                } else if (currentSum < k) {
                    right++;
                    currentSum = currentSum + sequence[right];
                } else {
                    currentSum = currentSum - sequence[left];
                    left++;
                }
            }
        }

        return answer;
    }
}

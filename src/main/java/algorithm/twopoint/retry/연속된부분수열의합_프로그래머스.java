package main.java.algorithm.twopoint.retry;

public class 연속된부분수열의합_프로그래머스 {

    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;

        int bestLeft = 0;
        int bestRight = sequence.length - 1;

        while (true) {
            if (sum >= k) {
                if (sum == k) {
                    if (right - 1 - left < bestRight - bestLeft) {
                        bestLeft = left;
                        bestRight = right - 1;
                    }
                }

                sum -= sequence[left];
                left++;
            } else {
                if (right == sequence.length) {
                    break;
                }

                sum += sequence[right];
                right++;
            }
        }

        return new int[]{bestLeft, bestRight};
    }
}

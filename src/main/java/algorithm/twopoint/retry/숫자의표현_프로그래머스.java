package main.java.algorithm.twopoint.retry;

public class 숫자의표현_프로그래머스 {

    public static void main(String[] args) {
        solution(1);
    }

    public static int solution(int n) {

        if (n == 1) {
            return 1;
        }

        int answer = 0;

        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < n) {
            if (sum == n) {
                answer++;
                if (right == n) {
                    break;
                }
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else {
                if (right == n) {
                    break;
                }
                right++;
                sum += right;
            }
        }

        return answer + 1;
    }
}

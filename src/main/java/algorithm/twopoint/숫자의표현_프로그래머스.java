package main.java.algorithm.twopoint;

public class 숫자의표현_프로그래머스 {

    public int solution(int n) {
        int answer = 1;

        int firstIndex = (n / 2) + 1;
        int secondIndex = (n / 2) + 1;

        while (true) {

            if (firstIndex <= 0) {
                break;
            }

            if (firstIndex == secondIndex) {
                firstIndex--;
            } else {
                int sum = 0;
                for (int i = firstIndex; i <= secondIndex; i++) {
                    sum = sum + i;
                }

                if (sum == n) {
                    firstIndex--;
                    answer++;
                } else if (sum > n) {
                    if (secondIndex > firstIndex) {
                        secondIndex--;
                    } else {
                        firstIndex--;
                    }
                } else if (sum < n) {
                    firstIndex--;
                }
            }
        }

        return answer;
    }
}
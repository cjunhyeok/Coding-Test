package main.java.algorithm.greedy.retry;

import java.util.Arrays;

public class 구명보트_프로그래머스 {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (true) {

            if (left > right) {
                break;
            }

            if (left == right) {
                answer++;
                break;
            }

            int leftWeight = people[left];
            int rightWeight = people[right];

            int sum = leftWeight + rightWeight;

            if (sum <= limit) {
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
        }

        return answer;
    }
}

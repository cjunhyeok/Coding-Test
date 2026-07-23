package main.java.algorithm.greedy.retry;

import java.util.Arrays;

public class 구명보트_프로그래머스 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {

            if (left == right) {
                answer++;
                break;
            }

            int leftPerson = people[left];
            int rightPerson = people[right];

            int weight = leftPerson + rightPerson;

            if (weight > limit) {
                right -= 1;
                answer++;
            } else {
                left += 1;
                right -= 1;
                answer++;
            }
        }

        return answer;
    }
}

package main.java.algorithm.greedy;

import java.util.Arrays;

public class 구명보트_프로그래머스 {

    public static void main(String[] args) {
        solution(new int[]{70, 50, 80}, 100);
    }

    public static int solution(int[] people, int limit) {

        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (true) {

            if (left == right) {
                answer++;
                break;
            }

            if (right < left) {
                break;
            }

            int min = people[left];
            int max = people[right];

            if (min + max <= limit) {
                answer++;
                left++;
                right--;
            } else {
                right--;
                answer++;
            }
        }

        return answer;
    }
}

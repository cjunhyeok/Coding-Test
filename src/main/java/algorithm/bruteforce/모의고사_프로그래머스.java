package main.java.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_프로그래머스 {

    public List<Integer> solution(int[] answers) {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        for (int i = 0; i < answers.length; i++) {
            int value = answers[i];

            if (first[i % first.length] == value) {
                firstCount++;
            }

            if (second[i % second.length] == value) {
                secondCount++;
            }

            if (third[i % third.length] == value) {
                thirdCount++;
            }
        }

        int maxScore = Math.max(firstCount, secondCount);
        maxScore = Math.max(maxScore, thirdCount);

        List<Integer> answer = new ArrayList<>();
        if (firstCount == maxScore) {
            answer.add(1);
        }

        if (secondCount == maxScore) {
            answer.add(2);
        }

        if (thirdCount == maxScore) {
            answer.add(3);
        }

        return answer;
    }
}

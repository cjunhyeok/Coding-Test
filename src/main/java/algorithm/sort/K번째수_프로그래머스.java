package main.java.algorithm.sort;

import java.util.Arrays;

public class K번째수_프로그래머스 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        int T = commands.length;
        answer = new int[T];

        for (int t = 0; t < T; t++) {
            int[] command = commands[t];
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] list = new int[j - i + 1];
            int index = 0;
            for (int iter = i - 1; iter < j; iter++) {
                list[index] = array[iter];
                index++;
            }

            Arrays.sort(list);
            answer[t] = list[k - 1];
        }

        return answer;
    }
}

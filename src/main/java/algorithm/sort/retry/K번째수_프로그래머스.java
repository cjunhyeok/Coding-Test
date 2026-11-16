package main.java.algorithm.sort.retry;

import java.util.Arrays;

public class K번째수_프로그래머스 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int t = 0; t < commands.length; t++) {
            int[] command = commands[t];
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2];

            int n = j - i;

            int[] list = new int[n];

            for (int index = 0; index < n; index++) {
                list[index] = array[i];
                i++;
            }

            Arrays.sort(list);

            answer[t] = list[k - 1];
        }

        return answer;
    }
}

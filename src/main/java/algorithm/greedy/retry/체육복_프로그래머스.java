package main.java.algorithm.greedy.retry;

import java.util.Arrays;

public class 체육복_프로그래머스 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] array = new int[n + 1];
        // 체육복 모두 1개씩 지급
        for (int i = 1; i <= n; i++) {
            array[i] = 1;
        }
        // 여벌 옷을 들고 온 인원
        for (int i : reserve) {
            array[i] = 2;
        }
        // 잃어버린 인원
        for (int i : lost) {
            array[i] = array[i] - 1;
        }

        for (int i = 1; i <= n; i++) {
            int current = array[i];

            if (current == 0) {
                int prev = array[i - 1];

                if (prev == 2) {
                    array[i - 1] = 1;
                    array[i] = 1;
                    continue;
                }

                if (i < n) {
                    int next = array[i + 1];

                    if (next == 2) {
                        array[i + 1] = 1;
                        array[i] = 1;
                        continue;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (array[i] != 0) {
                answer++;
            }
        }

        return answer;
    }
}

package main.java.algorithm.greedy;

import java.util.*;

public class 체육복_프로그래머스 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];

        Arrays.fill(clothes, 1);

        for (int r : reserve) {
            clothes[r]++;
        }

        for (int l : lost) {
            clothes[l]--;
        }

        Arrays.sort(lost);

        for (int l : lost) {
            if (clothes[l] > 0) {
                continue;
            }

            if (l - 1 >= 1 && clothes[l - 1] == 2) {
                clothes[l - 1]--;
                clothes[l]++;
            } else if (l + 1 <= n && clothes[l + 1] == 2) {
                clothes[l + 1]--;
                clothes[l]++;
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
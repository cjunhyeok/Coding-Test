package main.java.algorithm.sort;

import java.util.Arrays;

public class HIndex_프로그래머스 {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }

        return 0;
    }
}

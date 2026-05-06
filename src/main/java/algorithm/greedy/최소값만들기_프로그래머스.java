package main.java.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;

public class 최소값만들기_프로그래머스 {

    public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int reverseIndex = B.length - 1;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[reverseIndex];

            answer = answer + (a * b);
            reverseIndex--;
        }

        return answer;
    }
}

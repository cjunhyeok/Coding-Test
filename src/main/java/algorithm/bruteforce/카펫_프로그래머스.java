package main.java.algorithm.bruteforce;

public class 카펫_프로그래머스 {

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h != 0) continue;

            int w = total / h;

            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }

        return new int[]{};
    }
}

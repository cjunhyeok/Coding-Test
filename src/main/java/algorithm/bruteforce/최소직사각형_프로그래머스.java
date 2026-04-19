package main.java.algorithm.bruteforce;

public class 최소직사각형_프로그래머스 {

    public int solution(int[][] sizes) {
        int maxValue = 0;
        int minValue = 0;

        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];

            int max = Math.max(width, height);
            int min = Math.min(width, height);

            maxValue = Math.max(maxValue, max);
            minValue = Math.max(minValue, min);
        }

        return maxValue * minValue;
    }
}

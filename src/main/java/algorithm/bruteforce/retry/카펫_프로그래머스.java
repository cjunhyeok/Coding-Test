package main.java.algorithm.bruteforce.retry;

public class 카펫_프로그래머스 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i = 2; i < 5000; i++) {
            for (int j = 2; j < 2000000; j++) {
                int firstWidth = i - 2;
                int firstHeight = j - 2;

                if (firstWidth * firstHeight == yellow) {
                    int width = i * 2;
                    int height = (j - 2) * 2;

                    if ((width + height) == brown) {
                        answer = new int[]{i, j};
                        break;
                    }
                }
            }
        }

        return answer;
    }
}

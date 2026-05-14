package main.java.algorithm.greedy;

public class 마법의엘리베이터_프로그래머스 {

    public static void main(String[] args) {
        solution(95);
    }

    public static int solution(int storey) {
        int answer = 0;

        while (storey != 0) {

            if (storey == 10) {
                storey = 0;
                answer++;
            } else if (storey < 10) {
                if (storey <= 5) {
                    answer = answer + storey;
                    storey = 0;
                } else {
                    answer = answer + (10 - storey);
                    storey = 10;
                }
            } else {

                int divide = storey / 10;
                int mod = storey % 10;

                if (mod == 5) {

                    int next = divide % 10;
                    if (next >= 5) {
                        answer = answer + (10 - mod);
                        storey = divide + 1;
                    } else {
                        answer = answer + mod;
                        storey = divide;
                    }

                } else if (mod < 5) {
                    answer = answer + mod;
                    storey = divide;
                } else {
                    answer = answer + (10 - mod);
                    storey = divide + 1;
                }
            }


        }

        return answer;
    }
}

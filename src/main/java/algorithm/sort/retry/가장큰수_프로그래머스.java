package main.java.algorithm.sort.retry;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수_프로그래머스 {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> compare = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            compare.add(String.valueOf(numbers[i]));
        }

        compare.sort((a, b) -> {
            return (b + a).compareTo(a + b);
        });

        if (compare.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : compare) {
            sb.append(s);
        }

        return sb.toString();
    }
}

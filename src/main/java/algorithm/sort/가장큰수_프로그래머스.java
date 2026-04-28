package main.java.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수_프로그래머스 {
    public String solution(int[] numbers) {
        List<String> lists = new ArrayList<>();

        for (int number : numbers) {
            lists.add(String.valueOf(number));
        }

        lists.sort((a, b) -> (b + a).compareTo(a + b));
        if (lists.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String list : lists) {
            sb.append(list);
        }

        return sb.toString();
    }
}

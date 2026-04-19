package main.java.algorithm.datastructure;

import java.util.Arrays;

public class 전화번호목록_프로그래머스 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String line = phone_book[i];

            if (phone_book[i + 1].startsWith(line)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}

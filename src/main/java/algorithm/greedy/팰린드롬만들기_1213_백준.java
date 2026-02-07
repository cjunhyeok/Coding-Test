package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기_1213_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] values = new int[26];

        for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i) - 'A';
            values[index]++;
        }

        int oddCount = 0;
        int centerIndex = -1;

        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 != 0) {
                oddCount++;
                centerIndex = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < values[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String front = sb.toString();
        String center = (centerIndex == -1) ? "" : String.valueOf((char) (centerIndex + 'A'));
        String back = sb.reverse().toString();

        System.out.println(front + center + back);
    }
}

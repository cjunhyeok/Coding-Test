package main.java.algorithm.greedy.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 팰린드롬만들기_1213_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < line.length(); i++) {
            char value = line.charAt(i);

            if (map.containsKey(value)) {
                Integer count = map.get(value);
                map.put(value, count + 1);
            } else {
                map.put(value, 1);
            }
        }

        int OddCount = 0;
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                OddCount++;
            }
        }

        if (OddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] resultSet = new char[line.length()];
        int frontIndex = 0;
        int backIndex = line.length() - 1;

        for (Character c : map.keySet()) {
            Integer value = map.get(c);
            if (value % 2 == 0) {
                for (int i = 0; i < value / 2; i++) {
                    resultSet[frontIndex] = c;
                    frontIndex++;
                    resultSet[backIndex] = c;
                    backIndex--;
                }
            } else {
                resultSet[line.length() / 2] = c;
                value--;

                for (int i = 0; i < value / 2; i++) {
                    resultSet[frontIndex] = c;
                    frontIndex++;
                    resultSet[backIndex] = c;
                    backIndex--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            sb.append(resultSet[i]);
        }

        System.out.println(sb);
    }
}

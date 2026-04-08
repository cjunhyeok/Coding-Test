package main.java.algorithm.datastructure.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 백준_생태학_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        double totalCount = 0;
        Map<String, Double> map = new TreeMap<>();

        while ((line = br.readLine()) != null) {

            if (map.containsKey(line)) {
                Double value = map.get(line);
                map.put(line, value + 1);
            } else {
                map.put(line, 1d);
            }

            totalCount++;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            Double count = map.get(s);

            double value = count * 100 / totalCount;

            sb.append(s).append(' ').append(String.format("%.4f", value)).append('\n');
        }

        System.out.println(sb);
    }
}

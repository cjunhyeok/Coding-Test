package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 생태학_4358_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = null;

        double totalCount = 0d;
        Map<String, Double> treeMap = new TreeMap<>();

        while ((value = br.readLine()) != null) {

            if (treeMap.containsKey(value)) {
                Double count = treeMap.get(value);
                treeMap.put(value, count + 1);
            } else {
                treeMap.put(value, 1d);
            }

            totalCount++;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            String name = entry.getKey();
            double count = entry.getValue();

            double percent = (double) count * 100 / totalCount;

            sb.append(name)
                    .append(" ")
                    .append(String.format("%.4f", percent))
                    .append("\n");
        }

        System.out.println(sb);
    }
}

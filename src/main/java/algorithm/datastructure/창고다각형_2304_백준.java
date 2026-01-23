package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 창고다각형_2304_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            int H = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            Integer[] value = new Integer[2];
            value[0] = H;
            value[1] = L;

            list.add(value);
        }

        list.sort((s1, s2) -> {
            return s1[0] - s2[0];
        });

        Integer[] standardValue = new Integer[2];
        standardValue[0] = -1;
        standardValue[1] = -1;
        Integer standardIndex = -1;

        for (int i = 0; i < N; i++) {

            Integer[] value = list.get(i);

            if (value[1] > standardValue[1]) {
                standardValue = value;
                standardIndex = i;
            }

        }

        Integer result = 0;

        Integer X = list.get(0)[0];
        Integer Y = list.get(0)[1];

        for (int i = 1; i <= standardIndex; i++) {

            Integer[] value = list.get(i);
            Integer x = value[0];
            Integer y = value[1];

            if (y > Y) {
                int width = x - X;

                result = result + (width * Y);
                X = x;
                Y = y;
            }
        }

        X = list.get(list.size() - 1)[0];
        Y = list.get(list.size() - 1)[1];

        for (int i = list.size() - 2; i >= standardIndex; i--) {
            Integer[] value = list.get(i);
            Integer x = value[0];
            Integer y = value[1];

            if (y >= Y) {
                int width = X - x;

                result = result + (width * Y);
                X = x;
                Y = y;
            }
        }

        result = result + (standardValue[1]);

        System.out.println(result);
    }
}

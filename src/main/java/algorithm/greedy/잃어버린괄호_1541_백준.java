package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호_1541_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, "-");

        String firstLine = st.nextToken();
        StringTokenizer firstValues = new StringTokenizer(firstLine, "+");
        int result = 0;
        while (firstValues.hasMoreElements()) {
            result = result + Integer.parseInt(firstValues.nextToken());
        }

        while (st.hasMoreElements()) {
            String value = st.nextToken();
            StringTokenizer minusValues = new StringTokenizer(value, "+");

            while (minusValues.hasMoreElements()) {
                result = result - Integer.parseInt(minusValues.nextToken());
            }
        }

        System.out.println(result);
    }
}

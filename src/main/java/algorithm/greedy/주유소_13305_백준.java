package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] roads = new int[N - 1];
        int[] stations = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            int road = Integer.parseInt(st.nextToken());
            roads[i] = road;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int station = Integer.parseInt(st.nextToken());
            stations[i] = station;
        }

        int result = stations[0] * roads[0];
        int min = stations[0];

        for (int i = 1; i < N - 1; i++) {
            int currentStation = stations[i];

            if (currentStation < min) {
                min = currentStation;
            }

            result = result + (roads[i] * min);
        }

        System.out.println(result);
    }
}

package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 듣보잡_1764_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();

        StringTokenizer st = new StringTokenizer(NM, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> NSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            NSet.add(br.readLine());
        }

        Set<String> resultSet = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String value = br.readLine();

            if (NSet.contains(value)) {
                resultSet.add(value);
            }
        }

        List<String> collect = resultSet.stream().sorted().collect(Collectors.toUnmodifiableList());
        StringBuffer sb = new StringBuffer();
        for (String s : collect) {
            sb.append(s + "\n");
        }


        System.out.println(resultSet.size());
        System.out.println(sb);
    }

}

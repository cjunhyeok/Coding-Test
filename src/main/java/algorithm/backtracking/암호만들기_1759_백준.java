package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759_백준 {

    private static int L, C;
    private static char[] values;
    private static char[] path;
    private static boolean[] used;
    private static char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        path = new char[L];
        used = new boolean[C];
        values = new char[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            char value = st.nextToken().charAt(0);
            values[i] = value;
        }

        Arrays.sort(values);

        dfs(0, 0);

        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == L) {

            boolean isVowel = false;
            int consonantCount = 0;
            for (int i = 0; i < L; i++) {

                boolean isConsonant = true;

                for (int j = 0; j < vowel.length; j++) {
                    if (path[i] == vowel[j]) {
                        isVowel = true;
                        isConsonant = false;
                    }
                }

                if (isConsonant) {
                    consonantCount++;
                }
            }

            if (isVowel && consonantCount >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(path[i]);
                }
                sb.append('\n');
            }

            return;
        }


        for (int i = start; i < C; i++) {

            if (!used[i]) {
                used[i] = true;
                char value = values[i];
                path[depth] = value;

                dfs(i + 1, depth + 1);
                used[i] = false;
            }
        }
    }

    static boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}

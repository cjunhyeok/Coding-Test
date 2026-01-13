package main.java.algorithm.implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 그룹단어체커_1316_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = N;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String value = br.readLine();

            char beforeVal = '1';

            for (int j = 0; j < value.length(); j++) {
                char val = value.charAt(j);

                if (j == 0) {
                    set.add(val);
                    beforeVal = val;
                } else {
                    if (val == beforeVal) {
                        continue;
                    } else {
                        boolean isContain = set.contains(val);
                        if (isContain) {
                            result--;
                            break;
                        } else {
                            set.add(val);
                            beforeVal = val;
                        }
                    }
                }
            }

            set.clear();
        }

        System.out.println(result);
    }
}

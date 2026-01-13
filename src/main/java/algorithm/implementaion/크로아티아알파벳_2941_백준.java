package main.java.algorithm.implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 크로아티아알파벳_2941_백준 {

    public static void main(String[] args) throws IOException {

        List<String> croatia = new ArrayList<>();
        croatia.add("c=");
        croatia.add("c-");
        croatia.add("dz=");
        croatia.add("d-");
        croatia.add("lj");
        croatia.add("nj");
        croatia.add("s=");
        croatia.add("z=");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();

        for (String val : croatia) {
            boolean isContain = value.contains(val);

            if (isContain) {
                value = value.replaceAll(val, "A");
            }
        }

        System.out.println(value.length());
    }
}

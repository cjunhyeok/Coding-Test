package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 카드2_2164_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            linkedList.add(i);
        }

        boolean isPop = true;

        while (true) {
            if (linkedList.size() == 1) {
                break;
            }

            // 버린다
            if (isPop) {
                linkedList.removeFirst();
                isPop = false;
            } else {
                Integer first = linkedList.removeFirst();
                linkedList.addLast(first);
                isPop = true;
            }
        }

        System.out.println(linkedList.get(0));
    }
}

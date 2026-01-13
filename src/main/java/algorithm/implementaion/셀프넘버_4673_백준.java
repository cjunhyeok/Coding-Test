package main.java.algorithm.implementaion;

import java.util.ArrayList;
import java.util.List;

public class 셀프넘버_4673_백준 {

    public static void main(String[] args) {

        int number = 1;

        List<Integer> numbers = new ArrayList<>();

        while (true) {

            if (number > 10000) {
                break;
            }

            int value = 0;

            if (number < 10) {
                value = number + number;
            } else if (number < 100) {
                int tenDigit = number / 10;
                int oneDigit = number % 10;

                value = number + tenDigit + oneDigit;
            } else if (number < 1000) {
                int hundredDigit = number / 100;
                int tenDigit = (number % 100) / 10;
                int oneDigit = (number % 100) % 10;

                value = number + hundredDigit + tenDigit + oneDigit;
            } else if (number < 10000) {
                int thousandDigit = number / 1000;
                int hundredDigit = (number % 1000) / 100;
                int tenDigit = ((number % 1000) % 100) / 10;
                int oneDigit = ((number % 1000) % 100) % 10;

                value = number + thousandDigit + hundredDigit + tenDigit + oneDigit;
            }

            if (value <= 10000) {
                numbers.add(value);
            }

            number++;
        }

        for (int i = 1; i < 10000 ; i++) {
            if (!numbers.contains(i)) {
                System.out.println(i);
            }
        }

    }
}

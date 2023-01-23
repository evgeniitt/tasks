package ru.task4;

import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        int count = 0;
        int[] array = {1, 10, 2, 9};
        int a = IntStream.of(array).sum();
        int m = a / array.length;
        for (int s : array) {
            if (s < m) {
                do {
                    s++;
                    count++;
                } while (s < m);
            } else {
                do {
                    s--;
                    count++;
                } while (s > m);
            }
        }
        System.out.println(count);
    }
}

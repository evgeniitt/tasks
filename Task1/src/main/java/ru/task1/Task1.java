package ru.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int n = scan.nextInt();
        System.out.println("Введите длину обхода");
        int m = scan.nextInt();

        int[] array = new int[n];
        Arrays.setAll(array, i -> i + 1);

        int index = 0;
        do {
            System.out.print(array[index]);
            index = (index + m - 1) % n;
        }
        while (index != 0);
    }
}

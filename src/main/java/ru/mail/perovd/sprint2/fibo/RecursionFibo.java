package ru.mail.perovd.sprint2.fibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionFibo {
    private final int[] arr;

    public RecursionFibo(int number) {
        this.arr = new int[number + 2];
        arr[0] = 1;
        arr[1] = 1;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            RecursionFibo m = new RecursionFibo(number);
            System.out.println(m.fibo(number));
        }
    }

    private int fibo(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }
        arr[number - 1] = fibo(number - 1);
        return arr[number - 1] + arr[number - 2];
    }
}

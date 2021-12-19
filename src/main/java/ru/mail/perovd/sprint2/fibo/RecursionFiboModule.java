package ru.mail.perovd.sprint2.fibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RecursionFiboModule {

    private final int[] arr;
    private final int k;

    public RecursionFiboModule(int number, int k) {
        this.arr = new int[number + 2];
        arr[0] = 1;
        arr[1] = 1;
        this.k = (int) Math.pow(10, k);
    }

    private int fibo(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }
        arr[number - 1] = fibo(number - 1) % k;
        return arr[number - 1] + arr[number - 2];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int number = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            RecursionFiboModule m = new RecursionFiboModule(number, k);
            String count = String.valueOf(m.fibo(number));
            if (count.length() > k) {
                System.out.println(Integer.parseInt(count.substring(count.length() - k)));
            } else {
                System.out.println(Integer.parseInt(count));
            }
        }
    }
}

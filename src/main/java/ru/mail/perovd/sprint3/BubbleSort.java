package ru.mail.perovd.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BubbleSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] data = new int[count];
            for (int i = 0; i < count; ++i) {
                data[i] = Integer.parseInt(tokenizer.nextToken());
            }
            sort(data);
        }
    }

    private static void sort(int[] data) {
        int n = data.length;
        int times = 0;
        for (int j = 1; j < n; j++) {
            int f = 0;
            for (int i = 0; i <= n - 1 - j; i++) {
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                    f = 1;
                }
            }


            if (f == 0) {
                break;
            } else {
                times++;
                println(data);
            }
        }
        if (times==0){
            println(data);
        }
    }

    private static void println(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i : data) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    private static void swap(int[] data, int i, int j) {
        int a = data[i];
        int b = data[j];
        data[j] = a;
        data[i] = b;
    }
}

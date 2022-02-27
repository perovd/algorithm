package ru.mail.perovd.sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://russianblogs.com/article/5627527937/
public class CountTree {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(numTrees(n));
        }
    }

    public static int numTrees(int n) {
        int nums[] = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - j - 1];
            }
        }
        return nums[n];
    }
}

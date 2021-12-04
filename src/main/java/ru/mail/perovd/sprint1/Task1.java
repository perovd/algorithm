package ru.mail.perovd.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task1 {
    public static void main(String[] args) throws IOException {
        StringBuilder outputBuffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int y = (a * (x * x)) + (b * x) + c;
        outputBuffer.append(y).append("\n");

        System.out.println(outputBuffer);
    }
}

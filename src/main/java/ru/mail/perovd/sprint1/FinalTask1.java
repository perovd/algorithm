package ru.mail.perovd.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

//60349974
public class FinalTask1 {

    public static void main(String[] args) throws IOException {
        int[] numbers;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numLines = Integer.parseInt(reader.readLine());
            numbers = new int[numLines];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < numLines; ++i) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        String collect = Arrays.stream(dist(numbers)).boxed()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    static int[] dist(int[] numbers) {
        int[] result = new int[numbers.length];
        List<Integer> zeroPosition = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0L) {
                zeroPosition.add(i);
            }
        }
        for (int i = zeroPosition.get(0); i < numbers.length; i++) {
            if (numbers[i] == 0L) {
                result[i] = 0;
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
        for (int i = zeroPosition.get(zeroPosition.size() - 1); i >= 0; i--) {
            if (numbers[i] == 0L) {
                result[i] = 0;
            } else {
                result[i] = Math.min(result[i], result[i + 1] + 1);
            }
        }

        for (int i = zeroPosition.get(0) - 1; i >= 0; i--) {
            result[i] = result[i + 1] + 1;
        }
        return result;
    }
}

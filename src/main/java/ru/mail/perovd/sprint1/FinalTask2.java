package ru.mail.perovd.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//ID=60342973
public class FinalTask2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Integer> map = new HashMap<>(10);
            int k = Integer.parseInt(reader.readLine());
            for (int i = 0; i < 4; ++i) {
                String input = reader.readLine();
                for (int j = 0; j < 4; j++) {
                    map.putIfAbsent(input.substring(j, j + 1), 0);
                    map.computeIfPresent(input.substring(j, j + 1), (s, integer) -> integer += 1);
                }
            }
            System.out.println(score(map, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int score(Map<String, Integer> map, int k) {
        int maxScore = 0;
        for (int i = 0; i < 10; i++) {
            Integer orDefault = map.getOrDefault(String.valueOf(i), 0);
            if (orDefault > 0) {
                if (k >= orDefault || (k*2) >= orDefault) {
                    maxScore += 1;
                }
            }
        }
        return maxScore;
    }
}

package ru.mail.perovd.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//60350121
public class FinalTask2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] fields = new int[10];
            int k = Integer.parseInt(reader.readLine());
            for (int i = 0; i < 4; ++i) {
                String input = reader.readLine();
                for (int j = 0; j < 4; j++) {
                    String field = input.substring(j, j + 1);
                    if (field.equals(".")){
                        continue;
                    }
                    int idx = Integer.parseInt(field);
                    fields[idx] +=1;
                }
            }
            System.out.println(score(fields, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int score(int[] fields, int k) {
        int maxScore = 0;
        for (int i = 0; i < 10; i++) {
            int orDefault = fields[i];
            if (orDefault > 0) {
                if (k >= orDefault || (k*2) >= orDefault) {
                    maxScore += 1;
                }
            }
        }
        return maxScore;
    }
}

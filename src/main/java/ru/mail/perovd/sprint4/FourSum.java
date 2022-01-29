package ru.mail.perovd.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FourSum {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int s = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(tokenizer.nextToken());
            }
            effectiveSolution(s, data);
        }
    }

    private static void effectiveSolution(int a, int[] x) {
        int n = x.length;
        Arrays.sort(x);
        Set<Integer> history = new HashSet<>();
        Set<Integer> triples = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int target = a - x[i] - x[j];
                if (history.contains(target)){
                    HashSet<Integer> triple = new HashSet<>();
                    triple.add(target);
                    triple.add(x[i]);
                    triple.add(x[j]);
                   /// triples.put(triple);
                }
            }

        }
    }
}

package ru.mail.perovd.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;


public class Combination {

//    private static List<String> a = new ArrayList<>(2);
//    private static int n = 2;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            generate(input);
        }
    }

    private static void generate(String input) {
        List<String> a = new ArrayList<>(2);
        a.add("a");
        a.add("d");
        gen(0, a, a.size());
    }

    private static void gen(int t, List<String> a, int n) {
        if (t == n - 1) {
            System.out.println(a);
            return;
        } else {
            for (int j = t; j < n; ++j) {
                swap(a, t, j);
                t++;
                gen(t, a, n);
                t--;
                swap(a, t, j);
            }
        }
    }

}
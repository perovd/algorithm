package ru.mail.perovd.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsGenerator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            bracketGenerator(n, 0, 0, "");
        }
    }

    private static void bracketGenerator(int n, int counterOpen, int counterClose, String prefix) {
        if (counterOpen + counterClose == 2 * n) {
            System.out.println(prefix);
            return;
        }
        if (counterOpen < n) {
            bracketGenerator(n, counterOpen + 1, counterClose, prefix + "(");
        }
        if (counterOpen > counterClose) {
            bracketGenerator(n, counterOpen, counterClose + 1, prefix + ")");
        }
    }
}

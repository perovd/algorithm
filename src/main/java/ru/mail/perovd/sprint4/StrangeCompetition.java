package ru.mail.perovd.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StrangeCompetition {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();
            if (a.length() != b.length()) {
                System.out.println("NO");
                return;
            }
            if (hash(a) == hash(b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int hash(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        int idx = 0;
        int sum = 0;
        for (Character c : s.toCharArray()) {
            Integer integer = map.putIfAbsent(c, idx);
            if (integer == null) {
                sum = sum + idx;
                idx++;
            } else {
                sum = sum + integer;
            }
        }
        //      System.out.println(sb);
        return sum;
    }
}

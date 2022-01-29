package ru.mail.perovd.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Groups {

    private static List groups = new ArrayList<>();
    private static List<List<String>> keys;
    private static int count;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            count = Integer.parseInt(reader.readLine());
            keys = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                keys.add(null);
            }
            for (int i = 0; i < count; ++i) {
                String line = reader.readLine();
                int key = hash(line);
             //   System.out.println(line + " hash " + key );
                if (keys.get(key) == null) {
                    ArrayList<String> group = new ArrayList<>();
                    group.add(line);
                    keys.set(key, group);
                    groups.add(line);
                } else {
                    List<String> group = keys.get(key);
                    if (!group.contains(line)){
                        group.add(line);
                        groups.add(line);
                    }
                }
            }
            groups.forEach(System.out::println);
        }
    }

    private static int hash(String line) {
        return Math.abs(line.hashCode() + line.length()) % count;
    }
}

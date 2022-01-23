package ru.mail.perovd.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BigNumber {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            List<String> data = new ArrayList<>(count);
            for (int i = 0; i < count; ++i) {
                data.add(tokenizer.nextToken());
            }
            data.sort(new MyComparator());
            StringBuilder sb = new StringBuilder();
            for (String i : data) {
                sb.append(i);
            }
            System.out.println(sb);
        }
    }


    private static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1)*-1;
        }
    }
}



package ru.mail.perovd.sprint2.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LinkedQueue {

    private LinkedList<String> q = new LinkedList<>();


    private void get() {
        if (q.isEmpty()) {
            System.out.println("error");
            return;
        }
        System.out.println(q.removeFirst());
    }

    private void put(String x) {
        q.add(x);
    }

    private void size() {
        System.out.println(q.size());
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            LinkedQueue q = new LinkedQueue();
            for (int i = 0; i < commandCount; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String cmd = tokenizer.nextToken();
                if ("get".equals(cmd)) {
                    q.get();
                } else if ("size".equals(cmd)) {
                    q.size();
                } else if ("put".equals(cmd)) {
                    q.put(tokenizer.nextToken());
                } else {
                    throw new UnsupportedEncodingException("Unsupported command " + cmd);
                }
            }
        }
    }
}

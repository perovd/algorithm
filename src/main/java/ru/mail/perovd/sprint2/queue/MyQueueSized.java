package ru.mail.perovd.sprint2.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class MyQueueSized {

    private static final String NONE = "None";
    private final int maxSize;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private final String[] q;

    public MyQueueSized(int maxSize) {
        this.maxSize = maxSize;
        this.q = new String[maxSize];
    }

    //— добавить число x в очередь
    private void push(String x) {
        if (size == maxSize) {
            System.out.println("error");
            return;
        }

        q[tail] = x;
        tail = (tail + 1) % maxSize;
        size += 1;
    }

    // удалить число из очереди и вывести на печать;
    private void pop() {
        if (size == 0) {
            System.out.println(NONE);
            return;
        }
        String x = q[head];
        q[head] = NONE;
        head = (head + 1) % maxSize;
        size -= 1;
        System.out.println(x);
    }

    // — напечатать первое число в очереди;
    private void peek() {
        if (size == 0) {
            System.out.println(NONE);
            return;
        }
        String x = q[head];
        System.out.println(x);
    }

    // вернуть размер очереди;
    private void size() {
        System.out.println(size);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            int sizeQueue = Integer.parseInt(reader.readLine());
            MyQueueSized q = new MyQueueSized(sizeQueue);
            for (int i = 0; i < commandCount; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String cmd = tokenizer.nextToken();
                if ("peek".equals(cmd)) {
                    q.peek();
                } else if ("pop".equals(cmd)) {
                    q.pop();
                } else if ("size".equals(cmd)) {
                    q.size();
                } else if ("push".equals(cmd)) {
                    q.push(tokenizer.nextToken());
                } else {
                    throw new UnsupportedEncodingException("Unsupported command " + cmd);
                }
            }
        }
    }
}

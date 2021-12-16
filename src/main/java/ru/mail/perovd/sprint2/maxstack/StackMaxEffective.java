package ru.mail.perovd.sprint2.maxstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class StackMaxEffective {

    private static final String NONE = "None";
    private static final String ERROR = "error";
    private static final String GET_MAX = "get_max";
    private static final String POP = "pop";
    private static final String PUSH = "push";
    Stack<Integer> stack = new Stack<>();
    private int max;

    public static void main(String[] args) throws IOException {
        StackMaxEffective stackMax = new StackMaxEffective();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 4000)) {
            int numLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numLines; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String cmd = tokenizer.nextToken();
                if (GET_MAX.equals(cmd)) {
                    stackMax.get_max();
                } else if (POP.equals(cmd)) {
                    stackMax.pop();
                } else if (PUSH.equals(cmd)) {
                    stackMax.push(tokenizer.nextToken());
                } else {
                    throw new UnsupportedEncodingException("Unsupported command " + cmd);
                }
            }
        }
    }

    public void push(String x) {
        int value = Integer.parseInt(x);

        if (stack.empty()) {
            max = value;
            stack.push(value);
            return;
        }

        if (value > max) {
            stack.push(2 * value - max);
            max = value;
        } else {
            stack.push(value);
        }

    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println(ERROR);
            return;
        }
        Integer removed = stack.peek();
        stack.pop();
        if (removed >= max) {
            max = 2 * max - removed;
        }

    }

    public void get_max() {
        if (stack.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        System.out.println(max);
    }
}

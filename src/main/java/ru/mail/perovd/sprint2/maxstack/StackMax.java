package ru.mail.perovd.sprint2.maxstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StackMax {

    private static final String NONE = "None";
    public static final String ERROR = "error";
    List<Integer> stack = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        StackMax stackMax = new StackMax();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numLines; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String cmd = tokenizer.nextToken();
                if ("get_max".equals(cmd)) {
                    stackMax.get_max();
                } else if ("pop".equals(cmd)) {
                    stackMax.pop();
                } else if ("push".equals(cmd)) {
                    stackMax.push(tokenizer.nextToken());
                } else {
                    throw new UnsupportedEncodingException("Unsupported command " + cmd);
                }
            }
        }
    }


    public void push(String x) {
        stack.add(Integer.parseInt(x));
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println(ERROR);
            return;
        }
        stack.remove(stack.size() - 1);
    }

    public void get_max() {
        if (stack.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        System.out.println(stack.stream().max(Integer::compareTo).get());
    }
}

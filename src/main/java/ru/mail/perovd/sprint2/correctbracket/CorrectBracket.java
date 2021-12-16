package ru.mail.perovd.sprint2.correctbracket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CorrectBracket {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            char[] brackets = new char[line.length()];
            for (int i = 0; i < line.length(); i++) {
                brackets[i] = line.charAt(i);
            }
            System.out.println(isCorrectBracketSeq(brackets) ? "True" : "False");
        }
    }

    private static boolean isCorrectBracketSeq(char[] brackets) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; i < brackets.length; i++) {
                if (brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{') {
                    stack.push(brackets[i]);
                } else if (brackets[i] == map.get(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        } catch (EmptyStackException e){
            return false;
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean bracket(char left, char right) {
        if ('{' == left && '}' == right) {
            return true;
        } else if ('[' == left && ']' == right) {
            return true;
        } else if ('(' == left && ')' == right) {
            return true;
        }
        return false;
    }
}

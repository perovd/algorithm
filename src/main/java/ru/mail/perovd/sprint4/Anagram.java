package ru.mail.perovd.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagram {
    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; ++i) {
                String word = tokenizer.nextToken();
                process(word, i);
            }

            List<Group> list = new ArrayList<>(map.keySet().size());
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                list.add(new Group(entry.getValue()));
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (Group group : list) {
                sb.append(group).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static void process(String s, Integer number) {
        Integer key = h(s);
        if (map.containsKey(key)) {
            map.get(key).add(number);
        } else {
            LinkedList<Integer> tmp = new LinkedList<>();
            tmp.add(number);
            map.put(key, tmp);
        }
    }

    private static Integer h(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }

    private static class Group implements Comparable<Group>{
        int index;
        List<Integer> list;

        public Group(List<Integer> list) {
            this.list = list;
            Collections.sort(list);
            this.index = list.get(0);
        }

        @Override
        public int compareTo(Group o) {
            return Integer.compare(this.index, o.index);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            return sb.toString();
        }
    }
}

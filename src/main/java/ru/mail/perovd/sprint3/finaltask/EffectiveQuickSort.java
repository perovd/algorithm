package ru.mail.perovd.sprint3.finaltask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ID 64379865 https://contest.yandex.ru/contest/23815/run-report/64379865/
 *
 * Выбрать элемент из массива. Назовём его опорным.
 * Разбиение: перераспределение элементов в массиве таким образом, что элементы, меньшие опорного, помещаются перед ним, а большие или равные - после.
 * Рекурсивно применить первые два шага к двум подмассивам слева и справа от опорного элемента. Рекурсия не применяется к массиву, в котором только один элемент или отсутствуют элементы.
 *
 * Я вдохновился идеей решения из статьи https://ru.wikipedia.org/wiki/Быстрая_сортировка
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Сложность данной быстрой сортировки возрастает до O(n2), когда массив уже отсортирован или все его элементы равны.
 *
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Я не использовыал дополнительные структуры, сложность составляет O(n).
 */
public class EffectiveQuickSort {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            List<Participant> participants = new ArrayList<>(count);
            for (int i = 0; i < count; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                participants.add(
                        new Participant(tokenizer.nextToken(),
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken())));
            }

            quicksort(participants, 0, count - 1);

            for (int i = participants.size() - 1; i >= 0; i--) {
                System.out.println(participants.get(i).getLogin());
            }
        }
    }

    private static int partition(List<Participant> participants, int left, int right) {
        Participant pivot = participants.get((left + right) / 2);
        int i = left;
        int j = right;
        while (true) {
            while (participants.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (participants.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            Collections.swap(participants, i++, j--);
        }
    }


    private static void quicksort(List<Participant> participants, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(participants, left, right);
        quicksort(participants, left, pivot);
        quicksort(participants, pivot + 1, right);

    }

    private static class Participant implements Comparable<Participant> {
        private String login;
        private int done;
        private int fine;

        public Participant(String login, int done, int fine) {
            this.login = login;
            this.done = done;
            this.fine = fine;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getDone() {
            return done;
        }

        public void setDone(int done) {
            this.done = done;
        }

        public int getFine() {
            return fine;
        }

        public void setFine(int fine) {
            this.fine = fine;
        }

        @Override
        public int compareTo(Participant o) {
            int compare = this.done - o.done;
            if (compare != 0) {
                return compare;
            }
            compare = this.fine - o.fine;
            if (compare != 0) {
                return compare * -1;
            }
            return this.login.compareTo(o.login) * -1;
        }

        @Override
        public String toString() {
            return "Participant{" +
                    "login='" + login + '\'' +
                    ", done=" + done +
                    ", fine=" + fine +
                    '}';
        }
    }
}

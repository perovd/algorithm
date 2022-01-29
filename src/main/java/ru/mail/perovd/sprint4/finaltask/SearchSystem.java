import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ID 64615956 https://contest.yandex.ru/contest/24414/run-report/64615956/
 *
 * Построил индекс на основе Хеш-таблицы.
 * Ключ слово, значение Хеш-таблица где ключ "Номер документа" значение "Кол-во вхождений".
 *
 * Алгоритм поиска заключается в поиске всех документов по слову и агригация кол-ва вхождений по документу.
 * Затем сортировка результата и вывод не более 5 значений.
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * N - число повторений слова в строке,
 * M - число повторений слова в подстроке,
 * L - длину слова, то сложность алгоритма будет равна
 * O(N⋅M⋅L)
 *
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Сложность хеш-таблицы составляет O(n), я использовал 2 хеш-таблицы O(n²)
 */
public class SearchSystem {
    //Слово -> Номер документа -> Кол-во
    private static Map<String, Map<Integer, Integer>> index = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= n; ++i) {
                putToIndex(i, reader.readLine());
            }

            int m = Integer.parseInt(reader.readLine());
            for (int j = 0; j < m; ++j) {
                find(reader.readLine());
            }
            System.out.println(sb);
        }
    }

    private static void putToIndex(int number, String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreElements()) {
            String word = tokenizer.nextToken();
            if (index.containsKey(word)) {
                Map<Integer, Integer> tmp = index.get(word);
                tmp.computeIfPresent(number, (integer, integer2) -> integer2 + 1);
                tmp.computeIfAbsent(number, integer -> 1);

            } else {
                Map<Integer, Integer> document = new HashMap<>();
                document.put(number, 1);
                index.put(word, document);
            }
        }
    }

    private static void find(String line) {
        //Документ -> Сумма вхождения слова
        Map<Integer, Integer> buffer = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(line);
        Set<String> s = new HashSet<>();
        while (tokenizer.hasMoreElements()) {
            String word = tokenizer.nextToken();
            if (!s.add(word)) {
                continue; //Ищем только уникальные слова
            }
            if (index.containsKey(word)) {
                for (Map.Entry<Integer, Integer> tmp : index.get(word).entrySet()) {
                    buffer.computeIfPresent(tmp.getKey(), (integer, integer2) -> integer2 + tmp.getValue());
                    buffer.computeIfAbsent(tmp.getKey(), (integer) -> tmp.getValue());
                }
            }
        }
        List<Pair> collect = buffer.entrySet()
                .stream()
                .map(e -> new Pair(e.getKey(), e.getValue()))
                .sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < Math.min(collect.size(), 5); i++) {
            sb.append(collect.get(i).k).append(" ");
        }
        if (!collect.isEmpty()) {
            sb.append("\n");
        }
    }

    private static class Pair implements Comparable<Pair> {

        int k;
        int v;

        public Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            int compare = Integer.compare(v, o.v);
            if (compare != 0) {
                return compare * -1;
            }
            return Integer.compare(k, o.k);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ID 64555849 https://contest.yandex.ru/contest/24414/run-report/64555849/
 *
 * Реализовал хеш-таблицу на основе массива.
 * Для разрешения коллизий использовал метод цепочек.
 *
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Поиск в худшем случае O(n) - если все элементы попали в одну корзину и поиск осуществляется по связанному списку.
 * Добавления этого элемента в начало цепочки O(1).
 * Удаление в лучшем случае O(1).
 *
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность составляет O(n).
 */
public class MyMap {
    private static final String NONE = "None";
    private static final String GET = "get";
    private static final String PUT = "put";
    private static final String DELETE = "delete";

    private int bucketCount;
    private List<List<Entry>> data;

    public MyMap() {
        bucketCount = 1021;
        data = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            data.add(i, new LinkedList<>());
        }
    }

    //    put key value —– добавление пары ключ-значение. Если заданный ключ уже есть в таблице, то соответствующее ему значение обновляется.
    public void put(Integer key, Integer value) {
        int bucket = getBucket(key);
        List<Entry> chain = data.get(bucket);
        if (chain.isEmpty()) {
            chain.add(new Entry(key, value));
            return;
        }
        for (Entry entry : chain) {
            if (key.equals(entry.key)) {
                entry.value = value;
                return;
            }
        }
        chain.add(new Entry(key, value));
    }

    //    get key –— получение значения по ключу. Если ключа нет в таблице, то вывести «None». Иначе вывести найденное значение.
    public Integer get(Integer key) {
        int bucket = getBucket(key);
        List<Entry> chain = data.get(bucket);
        for (Entry entry : chain) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
        }
        throw new RuntimeException(NONE);
    }

    //    delete key –— удаление ключа из таблицы. Если такого ключа нет, то вывести «None», иначе вывести хранимое по данному ключу значение и удалить ключ.
    public Integer delete(Integer key) {
        int bucket = getBucket(key);
        List<Entry> chain = data.get(bucket);
        for (Entry entry : chain) {
            if (key.equals(entry.key)) {
                chain.remove(entry);
                return entry.value;
            }
        }
        throw new RuntimeException(NONE);
    }
    //Хеш-функция
    private int getBucket(Integer key) {
        return key.hashCode() % bucketCount;
    }

    public static void main(String[] args) throws IOException {
        MyMap m = new MyMap();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numLines = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numLines; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String cmd = tokenizer.nextToken();
                try {
                    if (GET.equals(cmd)) {
                        sb.append(m.get(Integer.parseInt(tokenizer.nextToken()))).append('\n');
                    } else if (PUT.equals(cmd)) {
                        m.put(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                    } else if (DELETE.equals(cmd)) {
                        sb.append(m.delete(Integer.parseInt(tokenizer.nextToken()))).append('\n');
                    } else {
                        throw new UnsupportedEncodingException("Unsupported command " + cmd);
                    }
                } catch (Exception e) {
                    sb.append(e.getMessage()).append('\n');
                }
            }
            System.out.println(sb);
        }
    }

    private static class Entry {
        int key;
        int value;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

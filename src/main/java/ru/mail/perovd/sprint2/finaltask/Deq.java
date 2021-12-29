import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;


/**
 * ID сборки 63248206
 * Я реализовал дек на основе массива.
 * -- ПРИНЦИП РАБОТЫ --
 * <p>
 * Все добавляемые в начало дек элементы добавляются в массив c права на лево с индексом рассчитанным по формуле (head - 1 + maxSize) % maxSize.
 * Все извлекаемые из начало дек элементы извлекаются из массива с лева на право по индексу на который указывает head.
 * <p>
 * Все добавляемые в конец дек элементы добавляются в массив с лева на право с индексом на который указывает tail.
 * Все извлекаемые из конца дек элементы извлекаются из массива c права на лево по индексу на который указывает индекс рассчитанный по формуле (tail - 1 + maxSize) % maxSize.
 * <p>
 * Я вдохновился идеей решения из статьи https://neerc.ifmo.ru/wiki/index.php?title=Дек
 * <p>
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Из описания алгоритма следует, если добавлять и получать элементы с одного конца, дек реализует принцип LIFO.
 * Т.к. по формуле расчета индекса добаляються элементы будут с права на лево, а извлекаться в противоположном порядке.
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Добавление в очередь стоит O(1), потому что добавление в массив стоит O(1).
 * <p>
 * Извлечение из очереди стоит O(1), потому что извлечение из массива O(1).
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Массив, содержащий n элементов, занимает O(n) памяти.
 * Поэтому и моя очередь будет потреблять  O(n) памяти.
 */
public class Deq {

    private final Integer[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private final int maxSize;

    public Deq(int size) {
        this.array = new Integer[size];
        this.maxSize = size;
        this.tail = 0;
    }

    /**
     * добавить элемент в конец дека. Если в деке уже находится максимальное число элементов, вывести «error».
     */
    private void pushBack(int value) {
        if (size == maxSize) {
            System.out.println("error");
            return;
        }
        array[tail] = value;
        tail = (tail + 1) % maxSize;
        size += 1;
    }

    /**
     * добавить элемент в начало дека. Если в деке уже находится максимальное число элементов, вывести «error».
     */
    private void pushFront(int value) {
        if (size == maxSize) {
            System.out.println("error");
            return;
        }
        head = (head - 1 + maxSize) % maxSize;
        array[head] = value;
        size += 1;
    }

    /**
     * вывести первый элемент дека и удалить его. Если дек был пуст, то вывести «error».
     */
    private void popFront() {
        if (size == 0) {
            System.out.println("error");
            return;
        }

        Integer x = array[head];
        head = (head + 1) % maxSize;
        size -= 1;
        System.out.println(x);
    }

    /**
     * вывести последний элемент дека и удалить его. Если дек был пуст, то вывести «error».
     */
    private void popBack() {
        if (size == 0) {
            System.out.println("error");
            return;
        }

        tail = (tail - 1 + maxSize) % maxSize;
        Integer x = array[tail];
        size -= 1;
        System.out.println(x);
    }


    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            int size = Integer.parseInt(reader.readLine());
            Deq deq = new Deq(size);
            for (int i = 0; i < commandCount; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String cmd = tokenizer.nextToken();
                if ("push_front".equals(cmd)) {
                    deq.pushFront(Integer.parseInt(tokenizer.nextToken()));
                } else if ("pop_front".equals(cmd)) {
                    deq.popFront();
                } else if ("pop_back".equals(cmd)) {
                    deq.popBack();
                } else if ("push_back".equals(cmd)) {
                    deq.pushBack(Integer.parseInt(tokenizer.nextToken()));
                } else {
                    throw new UnsupportedEncodingException("Unsupported command " + cmd);
                }
            }
        }
    }

}

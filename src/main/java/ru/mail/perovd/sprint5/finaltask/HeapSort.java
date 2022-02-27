import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;


/**
 * ID 65542135 https://contest.yandex.ru/contest/24810/run-report/65542135/
 *
 * Реализовал кучу на основе массива.
 *
 * Алгоритм добавления:
 * Добавляем элемент в конец кучи, восстанавливаем свойства кучи методом просеивания вверх.
 *
 * Алгоритм удаления:
 * Забираем элемент из начала кучи, восстанавливаем свойства кучи методом просееивания вниз.
 *
 * Я вдохновился идеей решения из статьи https://neerc.ifmo.ru/wiki/index.php?title=Двоичная_куча
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Сложность пирамидальной сортировки в худшем случае — O(n log n)
 *
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность составляет O(n).
 */
public class HeapSort {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Heap heap = new Heap(n);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                StringTokenizer t = new StringTokenizer(reader.readLine());
                heap.add(new Participant(t.nextToken(), Integer.parseInt(t.nextToken()), Integer.parseInt(t.nextToken())));
            }
            for (int i = 0; i < n; i++) {
                sb.append(heap.pop()).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static class Heap {
        private Participant[] arr;
        private int size = 0;

        public Heap(int capacity) {
            this.arr = new Participant[capacity + 1];
        }

        public void add(Participant participant) {
            this.size++;
            int index = this.size;
            this.arr[index] = participant;
            siftUp(index);
        }

        public Participant pop() {
            Participant result = this.arr[1];
            this.arr[1] = this.arr[size];
            this.size -= 1;
            siftDown(1);
            return result;
        }

        private void siftDown(int index) {
            while (2 * index <= this.size) {
                int left = 2 * index;      // left — левый сын
                int right = 2 * index + 1; // right — правый сын
                int largest = left;
                if (right < this.arr.length && arr[right].compareTo(arr[left]) > 0) {
                    largest = right;
                }
                if (arr[largest].compareTo(arr[index]) > 0) {
                    swap(index, largest);
                } else {
                    break;
                }
                index = largest;
            }
        }

        private void siftUp(int index) {
            while (index > 1 && arr[index].compareTo(arr[index / 2]) > 0) {
                swap(index / 2, index);
                index = index / 2;
            }
        }

        private void swap(int i, int j) {
            Participant t = this.arr[i];
            this.arr[i] = this.arr[j];
            this.arr[j] = t;
        }
    }

    private static class Participant implements Comparable<Participant> {
        String name;
        int task;
        int fine;

        public Participant(String name, int task, int fine) {
            this.name = name;
            this.task = task;
            this.fine = fine;
        }

        @Override
        public int compareTo(Participant o) {
            int compare = Integer.compare(task, o.task);
            if (compare != 0) {
                return compare;
            }
            compare = Integer.compare(fine, o.fine);
            if (compare != 0) {
                return compare * -1;
            }
            return name.compareTo(o.name) * -1;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Participant that = (Participant) o;
            return task == that.task && fine == that.fine && name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, task, fine);
        }
    }
}

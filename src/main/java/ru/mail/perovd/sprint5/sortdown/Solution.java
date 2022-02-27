package ru.mail.perovd.sprint5.sortdown;

public class Solution {
    public static int siftDown(int[] heap, int idx) {
        // Your code
        // “ヽ(´▽｀)ノ”

        while (2 * idx < heap.length) {
            int left = 2 * idx;       // left — левый сын
            int right = 2 * idx + 1; // right — правый сын
            int largest = left;
            if (right < heap.length && heap[right] > heap[left]) {
                largest = right;
            }
            if (heap[idx] < heap[largest]) {
                swap(heap, idx, largest);
            } else {
                break;
            }
            idx = largest;
        }
        return idx;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


//    private static void test() {
//        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
//        int i = siftDown(sample, 2);
//        assert i == 5;
//    }
//
//    public static void main(String[] args) {
//        test();
//    }
}
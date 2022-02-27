package ru.mail.perovd.sprint5.sortup;


public class Solution {
    public static int siftUp(int[] heap, int idx) {
        // Your code
        // “ヽ(´▽｀)ノ”
        while (idx > 1 && heap[idx] > heap[idx / 2]) {
            swap(heap, idx / 2, idx);
            idx = idx / 2;
        }
        return idx;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

//    private static void test() {
//        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
//        int i = siftUp(sample, 5);
//        assert i == 1;
//    }
//
//    public static void main(String[] args) {
//        test();
//    }
}
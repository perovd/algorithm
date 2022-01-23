package ru.mail.perovd.sprint3.finaltask;
/**
 * ID 64126590 https://contest.yandex.ru/contest/23815/run-report/64126590/
 *
 * Идея заключается в том, чтобы найти опорную точку,
 * разделить массив на два подмассива и выполнить двоичный поиск в каждой половине.
 *
 * В нашем случае "опорный элемент" это элемент который больше следующего элемента.
 *
 * Я вдохновился идеей решения из статьи https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Поиск в отсортированном массиве воспользовавшись алгоритмом бинарного поиска занимает O(log n).
 *
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Я не использовыал дополнительные структуры, сложность составляет O(n).
 */
public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        int size = arr.length - 1;
        int pivot = findPivot(arr, 0, size);

        if (pivot == -1) {
            return binarySearch(arr, 0, size, k);
        }

        if (arr[pivot] == k)
            return pivot;
        if (arr[0] <= k)
            return binarySearch(arr, 0, pivot - 1, k);
        return binarySearch(arr, pivot + 1, size, k);
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        System.out.println(brokenSearch(arr, 5));
    }

    //Метод нахождения опорной точки
    private static int findPivot(int[] arr, int left, int right) {
        if (right < left)
            return -1;
        if (right == left)
            return left;

        int mid = (left + right) / 2;
        if (mid < right && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > left && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[left] >= arr[mid])
            return findPivot(arr, left, mid - 1);
        return findPivot(arr, mid + 1, right);
    }

    //Бинарный поиск в отсортированном массиве
    private static int binarySearch(int arr[], int left, int right, int key) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (key > arr[mid]) {
            return binarySearch(arr, (mid + 1), right, key);
        }
        return binarySearch(arr, left, (mid - 1), key);
    }
}

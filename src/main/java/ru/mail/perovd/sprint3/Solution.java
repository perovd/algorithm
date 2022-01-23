import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {

        int[] arrLeft = Arrays.copyOfRange(arr, left, mid);
        int[] arrRight = Arrays.copyOfRange(arr, mid, right);

        int l = 0;
        int r = 0;
        int k = left;
        while (l < arrLeft.length && r < arrRight.length) {
            if (arrLeft[l] <= arrRight[r]) {
                arr[k] = arrLeft[l];
                l++;
            } else {
                arr[k] = arrRight[r];
                r++;
            }
            k++;
        }
        while (l < arrLeft.length) {
            arr[k] = arrLeft[l];
            l++;
            k++;
        }
        while (r < arrRight.length) {
            arr[k] = arrRight[r];
            r++;
            k++;
        }
        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left + 1 == right) {
            return;
        }
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);
        merge(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}
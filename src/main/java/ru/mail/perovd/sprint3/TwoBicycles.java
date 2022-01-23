package ru.mail.perovd.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoBicycles {

    private static int min;
    private static int max;


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int days = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] data = new int[days];
            for (int i = 0; i < days; ++i) {
                data[i] = Integer.parseInt(tokenizer.nextToken());
            }
            int amount = Integer.parseInt(reader.readLine());
//            int day = calc(data, amount, 0, days - 1);
//            System.out.print(getInteger(day, data, amount) + " ");
//            int day2 = calc(data, amount * 2, 0, days - 1);
//            System.out.println(getInteger(day2, data, amount * 2));
            int idx = -1;
            for (int i = 0; i < days - 1; i++) {
                if (data[i] >= amount) {
                    System.out.print(i + 1);
                    idx = i;
                    break;
                }
            }
            if (idx == -1) {
                System.out.print(-1);
                System.out.print(" ");
                System.out.println(-1);
                return;
            }
            System.out.print(" ");
            for (int i = idx; i < days; i++) {
                if (data[i] >= amount + amount) {
                    System.out.println(i + 1);
                    return;
                }
            }
            System.out.print(-1);
        }
    }


    private static Integer getInteger(int day, int[] data, int amount) {
        if (day == -1) {
            if (data[min] >= amount) {
                return min + 1;
            }
            if (data[max] >= amount) {
                return max + 1;
            }
        }
        return day == -1 ? -1 : day + 1;
    }

    private static int calc(int[] arr, int x, int left, int right) {
        //Base case, range is empty
        if (right <= left) {
            return -1;
        }
        int mid = (left + right) / 2;
        //Base case, element is found
        if (arr[mid] == x) {
            return mid;
        } else if (x < arr[mid]) {
            max = mid;
            return calc(arr, x, left, mid);
        } else {
            min = mid + 1;
            return calc(arr, x, mid + 1, right);
        }
    }
}

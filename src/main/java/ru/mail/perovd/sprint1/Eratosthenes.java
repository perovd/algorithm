package ru.mail.perovd.sprint1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Eratosthenes {

    public static void main(String[] args) {
      //  getLeastPrimesLinear(8);
        int a = Integer.MAX_VALUE + 10;
        System.out.println(a);
       // print(getSmallerPrimes(9));
    }

    private static void print(Integer[] numbers) {
        String collect = Stream.of(numbers)
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("[" + collect + "]");
    }

    private static Integer[] getSmallerPrimes(int n) {
        List<Integer> smallerPrimes = new ArrayList<>();
        for (int i = 2; i < n + 1; i++) {
            if (isPrime(i)) {
                smallerPrimes.add(i);
            }
        }
        return smallerPrimes.toArray(new Integer[0]);
    }


//    private static Integer eratosthenesEffective(Integer n) {
//
//        Object[] primes = new boolean[n + 1];
//        Arrays.fill(primes, true);
//        primes[0] = false;
//        primes[1] = false;
//        for (int i = 2; i < primes.length; ++i) {
//            if (primes[i]) {
//                for (int j = 2; i * j < primes.length; ++j) {
//                    primes[i * j] = false;
//                }
//            }
//        }
//        return 0;
//    }

    private static void getLeastPrimesLinear(int n) {
        int[] lp = new int[n + 1];
        int[] primes = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes[i] = i;
            }
            for (int p : primes) {
                int x = p * i;
                if ((p > lp[i]) || (x>n)){
                    break;
                }
                lp[x] = p;
            }
        }
        System.out.println(lp);
        System.out.println(primes);
    }

    private static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i += 1;
        }
        return true;
    }
}

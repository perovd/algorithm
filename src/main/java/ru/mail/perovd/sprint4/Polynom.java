package ru.mail.perovd.sprint4;

import java.io.IOException;
import java.util.Random;


public class Polynom {
    private static int a = 1000;
    private static int m = 123987123;
    private static int window = 2;

    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            a = Integer.parseInt(reader.readLine());
//            m = Integer.parseInt(reader.readLine());
//            String s = reader.readLine();
//            System.out.println(h2(s));
//        }
        System.out.println(getRandomString(20));
        while (true) {
            String a = getRandomString(20);
            String b = getRandomString(20);
            if (h2(a) == h2(b)) {
                System.out.println(a);
                System.out.println(b);
                return;
            }
        }
    }

    private static long h2(String s) {
        long hash = 0;

        for (int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);
            hash = (hash * a + ascii) % m;
        }
        return hash;
    }

    // длина Длина строки, требуемой пользователем gbpdcvkumyfxillgnqrv
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(26);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}

package ru.mail.perovd.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seq {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            if(s.isEmpty()){
                System.out.println("True");
                return;
            }
            String t = reader.readLine();
            if(t.isEmpty()){
                System.out.println("False");
                return;
            }

            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            int l =0; int r= 0; int k =0;
            while (l < chars.length && r < chars1.length){
                if (chars[l] == chars1[r]){
                    l++;
                    r++;
                } else {
                    r++;
                }
            }
            if (l == chars.length){
                System.out.println("True");
            } else{
                System.out.println("False");
            }
        }
    }

}

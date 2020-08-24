package com.interview;

import java.util.Scanner;

public class T20200822_360_1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            boolean b = Check01(str);
            if(b)
                count++;
        }
        System.out.println(count);
    }

    private static boolean Check01(String str) {
        if(str.length() > 10)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isLetter(str.charAt(i)) )
                return false;
        }
        return true;
    }
}

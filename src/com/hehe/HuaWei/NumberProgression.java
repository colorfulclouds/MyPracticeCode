package com.hehe.HuaWei;

import java.util.Scanner;

public class NumberProgression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int length = sc.nextInt(); // n
            int first = 2, last = 3 * length - 1; // a1, an
            System.out.println((first + last) * length / 2);
        }
        sc.close();
    }

}

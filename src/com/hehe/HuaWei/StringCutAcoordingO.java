package com.hehe.HuaWei;

import java.util.Scanner;

public class StringCutAcoordingO {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int count = 0;
        int len = chars.length;
        for (char c : chars) {
            if (c == 'o') {
                count++;
            }
        }
        if (count % 2 == 0)
            System.out.println(len);
        else
            System.out.println(len-1);

    }
}

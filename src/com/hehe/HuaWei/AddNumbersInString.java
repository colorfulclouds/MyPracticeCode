package com.hehe.HuaWei;

import java.util.Scanner;

/**
 * aa12-34bb
 * -31
 *
 * aa
 * 0
 *
 * 空输入
 * 0
 *
 * 0
 * 0
 */
public class AddNumbersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '-') {
                int p = i + 1;
                while (p < chars.length && Character.isDigit(chars[p]))
                    p++;
                String sub = s.substring(i + 1, p);
                if (sub.length() > 0)
                    res -= Integer.parseInt(sub);
                i = p;
                continue;
//                i++;
//                int p = i;
//                while (i < chars.length && Character.isDigit(chars[i])) {
//                    i++;
//                }
//                String sub = s.substring(p, i);
//                if (sub.length() > 0) {
//                    res -= Integer.parseInt(sub);
//                }
//                i--;
//                continue;
            }
            if (Character.isDigit(c)) {
                res += Character.digit(c, 10);
            }
        }
        System.out.println(res);
    }
}

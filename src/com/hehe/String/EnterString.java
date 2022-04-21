package com.hehe.String;

import java.util.Scanner;

/**
 * 字符串遇到某个字母(N)换行
 * <p>
 * 先替换再截取
 */
public class EnterString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int start = 0;
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        s = s.replace('n', 'N');

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'N') {
                if (start < j)
                    System.out.println(s.substring(start, j));
                start = j;
            }
        }
        System.out.println(s.substring(start));
    }
}

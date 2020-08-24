package com.hehe.String;

import java.util.Scanner;

/**
 * 字符串遇到某个字母换行
 */
public class EnterString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        /**
         * 法1：截取完再替换
         */
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'n' && i > 0)) {
                String tmp = s.substring(a, i);
                tmp = Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1);
                System.out.println(tmp);
                a = i;
            }
            String tmp = s.substring(a);
            tmp = Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1);
            System.out.println(tmp);

    }

        /**
         * 法2：先替换再截取
         */
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

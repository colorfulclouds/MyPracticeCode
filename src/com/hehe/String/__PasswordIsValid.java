package com.hehe.String;

import java.util.Scanner;

/**
 * .长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 */
public class __PasswordIsValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int len = str.length();
            if (len <= 8 || str.equals("") || str == null)
                System.out.println("NG");
            else if (isSubRepeats(str))
                System.out.println("NG");
            else
                System.out.println(isLeastThree(str));
        }
    }

    private static String isLeastThree(String str) {
        char[] chars = str.toCharArray();
        int[] bit = {0, 0, 0, 0};
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c))
                bit[0] = 1;
            else if (c >= 'a' && c <= 'z')
                bit[1] = 1;
            else if (c >= 'A' && c <= 'Z')
                bit[2] = 1;
            else
                bit[3] = 1;
        }
        if (bit[0] + bit[1] + bit[2] + bit[3] >= 3)
            return "OK";
        else
            return "NG";
    }

    private static boolean isSubRepeats(String str) {
        for (int i = 0; i < str.length() - 3; i++) {
            String sub = str.substring(i, i + 3);
            String sub2 = str.substring(i + 3, str.length());
            if (sub2.contains(sub))
                return true;
        }
        return false;
    }
}

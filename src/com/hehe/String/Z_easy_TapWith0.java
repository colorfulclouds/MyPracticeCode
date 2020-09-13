package com.hehe.String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入多个字符串：
 *   将每个字符串按8位切割
 *   不足8位的补0
 */
public class Z_easy_TapWith0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num = Integer.parseInt(sc.nextLine());
        String[] str = new String[2];
        for (int i = 0; i < 2; i++) {
            str[i] = sc.nextLine();
        }

        Cut(str);

//        String[] str = {"12345678","dwdwd"};
//        Cut(str);
    }

    public static void Cut(String[] str) {
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (s.length() % 8 != 0)
                s = s + "0000000";
            while (s.length() >= 8) {
                res.add(s.substring(0,8));
                s = s.substring(8);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

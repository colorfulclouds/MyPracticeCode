package com.hehe.RecursiveAndDynamic;

import java.util.jar.JarOutputStream;

public class MaxSubStr {
    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "cdefg";
        a = " " + a;
        b = " " + b;
//        System.out.println(a.substring(3, 5));
        System.out.println(a.charAt(3) == b.charAt(1));
        String res = getLCS(a, b);
        System.out.println(res);


    }

    public static String getLCS(String str1, String str2) {
        int[][] record = new int[str2.length()][str1.length()];
        int maxLen = 0, maxEnd = 0;

        for (int i = 1; i < str2.length(); ++i)
            for (int j = 1; j < str1.length(); ++j) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    record[i][j] = record[i - 1][j - 1] + 1;
                } else {
                    record[i][j] = 0;
                }
                if (record[i][j] > maxLen) {
                    maxLen = record[i][j];
                    maxEnd = j; //若记录i,则最后获取LCS时是取str1的子串
                }
            }
        return str1.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

}

package com.hehe.RecursiveAndDynamic;

import java.util.jar.JarOutputStream;

public class MaxSubStr {
    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "cdefg";
//        a = " " + a;
//        b = " " + b;
//        System.out.println(a.substring(3, 5));
        System.out.println(a.charAt(3) == b.charAt(1));
        String res = getLCS(a, b);
        System.out.println(res);


    }

    public static String getLCS(String str2, String str1) {
        if(str1 == null || str2 == null){
            return new String();
        }
        str1 = " " + str1;
        str2 = " " + str2;
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

    public static int getLCS01(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength][tLength];

        for (int i = 0; i < sLength; i++) {
            for (int k = 0; k < tLength; k++) {

                if (s.charAt(i) == t.charAt(k)) {
                    if (i == 0 || k == 0) {
                        dp[i][k] = 1;
                    } else {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }
                    result = Math.max(dp[i][k], result);
                } else {
                    dp[i][k] = 0;
                }

            }
        }
        return result;
    }

}

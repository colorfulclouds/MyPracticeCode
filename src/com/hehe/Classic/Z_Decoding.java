package com.hehe.Classic;

public class Z_Decoding {

    public static int numDecodings(String s) {
        // 解题思路:
        // 基本是斐波拉契数列dp[i]=dp[i-1]+dp[i-2]    //dp[i]表示s[0-(i-1)]的解法的个数
        // dp[i-1]表示单独加入新的数字,dp[i-2]表示和前面一个数字凑

        if (s.length() == 0 || s == null || (s.length() > 1 && s.charAt(0) == '0')) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        System.out.println(s.length());
        System.out.println(dp.length);

        dp[0] = 1; // 这个占用位并没有实际意义，只是为了使代码更顺畅

        for (int i = 1; i < dp.length; i++) {
            // 前面一个字符不是'0'则dp[i]至少等于dp[i-1]
            if (s.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }

            //=======================================条件的含义？？？？========================
            // 判断前一个字符和当前字符是不是可以凑
            if ((i > 1 && s.charAt(i - 1) <= '6' && s.charAt(i - 2) == '2') || (i > 1 && s.charAt(i - 2) == '1')) {
                dp[i] += dp[i - 2];
            }
            //=======================================条件的含义？？？？========================

        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("11145"));

    }


    //不加注释版
    public static int numDecodings01(String s) {

        if (s.length() == 0 || s == null || (s.length() > 1 && s.charAt(0) == '0')) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            if (s.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }

            if ((i > 1 && s.charAt(i - 1) <= '6' && s.charAt(i - 2) == '2') || (i > 1 && s.charAt(i - 2) == '1')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}


package com.hehe.String;

/**
 * 题意
 * 模式匹配, 串中包含的模式串的个数
 * 其中？为万能符
 * ababa
 * aba
 * 2
 * <p>
 * aba?a
 * aba
 * 2
 */

//思路：
//暴力循环   s1.length() - s2.length()+1   次
//父循环内：
//    对子串循环，一个不匹配就结束，最后一个字符之前的匹配情况不用处理
//              先处理匹配到最后一个字符且最后一个字符也匹配
//    父循环继续

public class SubStr_PatternMatch_easy {

    public static void main(String[] args) {

        String s1 = "ababa";
        String s2 = "abcabaabc";
        String s3 = "abc";

        System.out.println(strPattern(s1, s3));
        System.out.println(strPattern(s2, s3));

        System.out.println("==================================");
        System.out.println(getNum(s2, s3));

        System.out.println("==================================");
        //matches
        System.out.println(s1.matches("(.*)"));
    }

    //求解字符串内含有多少模式串
    public static int strPattern(String s1, String s2) {
        int count = 0;
        int lim = s1.length() - s2.length();
        int k = 0;
        while (k <= lim) {
            for (int j = 0; j < s2.length(); j++) {
//                System.out.println(s1.charAt(k + j) + "===");
//                System.out.println(s2.charAt(j));
                if (j == s2.length() - 1 && (s1.charAt(k + j) == '?' || s1.charAt(k + j) == s2.charAt(j)))
                    count++;
                if (s1.charAt(k + j) != '?' && s1.charAt(k + j) != s2.charAt(j)) {
                    break;
                }
            }
            k++;
        }
        return count;
    }

    public static int getNum(String s, String pattern) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = i;

            int j = 0;
            for (; j < pattern.length(); j++) {
                if (s.charAt(i) != pattern.charAt(j))
                    break;
                if (i + 1 < s.length())
                    i++;
            }
            if (j == pattern.length())
                cnt++;

            i = tmp; //i回到比较开始的地方 进行循环中的i++，进入下一个字母开始的比较中
        }
        return cnt;
    }


}
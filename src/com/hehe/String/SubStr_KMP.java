package com.hehe.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断串(N)中是否包含模式串（m）暴力(N>=m): O(N*m)
 */
public class SubStr_KMP {
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println("=================KMP=================");
        System.out.println(getIndexOf(str, match));

        System.out.println("=================getNextArray:==================");
        String s = "aabaaba";
        int[] arr = getNextArray(s.toCharArray());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("=================暴力 ==================");
        System.out.println(indexOf("abc", "bcd"));
        System.out.println(indexOf("abc", "bc"));
        System.out.println(indexOf(str, match));
        System.out.println("================暴力 简单方法===================");
        System.out.println(indexOf01("abc", "bcd"));
        System.out.println(indexOf01("abc", "bc"));
        System.out.println(indexOf01(str, match));

        //反转在子串中的运用
//        String a = "abc";
//        String b = "bc";
//        StringBuilder sb = new StringBuilder(a);
//        System.out.println(sb.indexOf(b));
//
//        for (int i = 0; i < a.length() - 1; i++) {
//            if(a.substring(i, i + 2).equals(b))
//                System.out.println(i);

    }

    /**
     * KMP   返回子串在串中的起始下标
     *
     * @param s
     * @param p
     * @return
     */
    public static int getIndexOf(String s, String p) {
        if (s == null || p == null || p.length() < 1 || s.length() < p.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int si = 0;
        int pi = 0;
        int[] next = getNextArray(ps);
        while (si < ss.length && pi < ps.length) {
            if (ss[si] == ps[pi]) {
                si++;
                pi++;
            } else if (next[pi] == -1) {  //子串已经在起始位置 还是无法匹配 被匹配的串 下标右移
                si++;
            } else {
                pi = next[pi];
            }
        }
        return pi == ps.length ? si - pi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    /**
     * 暴力 子串索引位置
     *
     * @param s
     * @param pattern
     * @return
     */
    public static int indexOf(String s, String pattern) {
        int index = -1;
        int lim = s.length() - pattern.length();
        int k = 0;
        while (k <= lim) {
            for (int j = 0; j < pattern.length(); j++) {
                boolean isEqual = s.charAt(k + j) == pattern.charAt(j);
                if (isEqual && j == 0) {
                    index = k + j;
                }
                if (!isEqual) {
                    break;
                }
                if (isEqual && j == pattern.length() - 1)
                    return index;
            }
            k++;
        }
        return index;
    }

    /**
     * 暴力 简单
     *
     * @param s
     * @param pattern
     * @return
     */
    public static int indexOf01(String s, String pattern) {
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
                return tmp;
            i = tmp;
        }
        return -1;
    }

}


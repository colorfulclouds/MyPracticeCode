package com.hehe.String;

public class KMP {
    /**
     *判断串(N)中是否包含模式串（m）暴力(N>=m): O(N*m)
     */

    /**
     *返回子串在串中的起始下标
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
            return new int[] { -1 };
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

    public static void main(String[] args) {
//        String str = "abcabcababaccc";
//        String match = "ababa";
//        System.out.println(getIndexOf(str, match));
        String s = "aabaaba";
        int[] arr = getNextArray(s.toCharArray());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}


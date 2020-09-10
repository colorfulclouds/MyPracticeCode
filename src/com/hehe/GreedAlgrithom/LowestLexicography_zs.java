package com.hehe.GreedAlgrithom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 贪心策略的比较器
 * 多个字符串 拼接成最小的 字典序字符串
 */

public class LowestLexicography_zs {

    /**
     * 公共的比较方法1
     */
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    /**
     * 公共的比较方法2
     * Arrays.sort(strs, new MyComparator01()); 不能用？？？？？
     */
    public static class MyComparator01 implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        }
    }

    /**
     * 1、最小的字典序字符串
     *
     * @param strs
     * @return
     */
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
//        Arrays.sort(strs, new MyComparator01());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    /**
     * 2、数字组成的最小的数字
     * hehe
     * @param nums
     * @return
     */
    public static int lowestNum01(int[] nums) {
        String[] strs = new String[nums.length];  //只能用 比较字符串的 MyComparator，比较整型的MyComparator01不能用？？？
        int i = 0;
        for (int s : nums) {
            strs[i++] = String.valueOf(s);
        }
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int j = 0; j < strs.length; j++) {
            res += strs[j];
        }
        if (res != null)
            return Integer.valueOf(res);
        else
            return 0;

    }

    /**
     * 2-1 数组组成的最小的数字
     * 网友
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for (int j : list) {
            s += j;
        }
        return s;

    }


    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));

    }

}


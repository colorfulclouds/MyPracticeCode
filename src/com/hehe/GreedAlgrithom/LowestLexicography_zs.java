package com.hehe.GreedAlgrithom;

import java.util.*;

/**
 * 贪心策略的比较器
 * 多个字符串 拼接成最小的 字典序字符串
 */

public class LowestLexicography_zs {
    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b", "ca"};
        System.out.println(lowestString(strs2));

        int[] arr = {1, 42, 24, 22, 10, 2};
        System.out.println(PrintMinNumber(arr));
        System.out.println("下面对于数字数组的字典序输出的错误的：");
        System.out.println(PrintMinNumber01(arr)); //【错误的】

        List<Integer> integers = lexicalOrder(10);
        for (int i : integers) {
            System.out.print(i + " ");
        }


        System.out.println("+++++++++++++++++++++");
        System.out.println(minSeqString("aadc"));
        System.out.println(minSeqString("adc"));
        System.out.println(minSeqString("abc"));

    }

    /**
     * 1、字符串的 最小的字典序
     *
     * @param strs
     * @return
     */
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    /**
     * 字符串变换最小字符串 要求：仅交换一个字符的最小字典序
     * <p>
     * <p>
     * aadc
     * aacd
     * <p>
     * abc
     * abc
     *
     * @param str
     * @return
     */
    public static String minSeqString(String str) {
        List<String> list = new ArrayList<>();
        list.add(str);
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String res = swap(str, i, j);
                list.add(res);
            }
        }
        Collections.sort(list);
        return list.get(0);

    }

    private static String swap(String str, int a, int b) {
        char[] chars = str.toCharArray();
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
        return String.valueOf(chars);
    }


    //===============================================================


    //=======================2 参数中 内置的比较器=======================

    /**
     * 2-1 数组组成的最小的数字（int数组转化为字符串进行比较器排序）
     * 网友
     *
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int[] numbers) {
        String res = "";
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {   //Collections.sort
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for (int s : list) {
            res += s;
        }
        return res;
    }

    /**
     * 2-2 【错误的】数组组成的最小的数字（int数组中的数字比较大小 从而字典序排序）
     * 网友
     *
     * @param numbers
     * @return
     */
    public static String PrintMinNumber01(int[] numbers) {
        String res = "";
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {   //Collections.sort
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int s : list) {
            res += s;
        }
        return res;

    }

    //================================外置的比较器=======================
    public static class MyComparatorSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MyComparator01 implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        }
    }

    //===================================================================================

    /**
     * 3 给定一个整数 n, 返回从 1 到 n 的字典顺序。
     * 例如，
     * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     * <p>
     * 字典序可以抽象成一棵树
     * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     * 所以，有小到大输出其实就是输出他的先序遍历
     * 参考二叉搜索树的先序遍历写法
     * 1.递归：
     * 此处不一样的是需要舍去头结点0，以1-9分别为根节点进行遍历输出：
     * 1.递归结束条件，当前结点＞n则递归结束
     * 2.将元素值添加进入res,遍历其10个兄弟结点，进入递归其子节点
     *
     * @param n
     * @return
     */
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private static void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }


}


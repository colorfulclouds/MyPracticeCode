package com.hehe.GreedAlgrithom;

import java.util.*;

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
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2;
//        }

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
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    /**2、数字组成的最小的数字(int 转成 String 使用 MyComparator)
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

    /**2-1 数组组成的最小的数字
     * 网友
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
     * 3 给定一个整数 n, 返回从 1 到 n 的字典顺序。
     * 例如，
     * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     *
     * 字典序可以抽象成一棵树
     * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     * 所以，有小到大输出其实就是输出他的先序遍历
     * 参考二叉搜索树的先序遍历写法
     * 1.递归：
     * 此处不一样的是需要舍去头结点0，以1-9分别为根节点进行遍历输出：
     * 1.递归结束条件，当前结点＞n则递归结束
     * 2.将元素值添加进入res,遍历其10个兄弟结点，进入递归其子节点
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }
    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b", "ca"};
        System.out.println(lowestString(strs2));

        int[] arr = {1, 4, 22, 23};
        System.out.println(PrintMinNumber(arr));

    }

}


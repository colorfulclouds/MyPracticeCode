package com.hehe.RecursiveAndDynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 递归
 * 1、打印串、数组的全部子序列
 * 2、数组中数字任意组合 是否能得到一个给定值
 */
public class Print_All_Subsquences_zs {

    public static void main(String[] args) {
        //打印打印串、数组的全部子序列
        String test = "abc";
//        printAllSubsquence(test);
        printAllSub(test.toCharArray(), 0, new String());


        //数组中数字任意组合 是否能得到一个给定值
//        int[] arr = {1,2,7,4};
//        System.out.println(isSum01(arr,0,0,11));;
    }

    /**
     * 打印数组的全部子序列（非子串，子串是连续的）
     * @param chars
     * @param i
     * @param res
     */
    public static void printAllSub(char[] chars, int i, String res) {
        if (i == chars.length) {
            System.out.println(res);
            return;  //返回类型是void的函数使用return语句是为了引起函数的强制结束，这种return的用法类似于循环结构中的break语句。
        }
        printAllSub(chars, i + 1, res);
        printAllSub(chars, i + 1, res + String.valueOf(chars[i]));
    }


    private static boolean isSum01(int[] arr, int i, int sum, int aim) {
        if (i == arr.length)
            return sum == aim;
        return isSum01(arr, i + 1, sum, aim) || isSum01(arr, i + 1, sum + arr[i], aim);

    }

    //===================================================未看=========================================================
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    public static void process(char[] chs, int i, List<Character> res) {
        if (i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i + 1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(chs, i + 1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list) {
        return null;
    }


}

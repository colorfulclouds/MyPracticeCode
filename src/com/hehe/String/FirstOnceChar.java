package com.hehe.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 找出字符串中 第一次只出现一次的字符
 */
public class FirstOnceChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //设置信号量
        int signal = 0;
        //读取输入内容
        String str = sc.nextLine();
        //遍历输入内容
        for (int i = 0; i < str.length(); i++) {
//            int i1 = str.lastIndexOf(str.charAt(i));
//            int i2 = str.indexOf(str.charAt(i));
            //判断每个字符是否出现第二次，如果存在，设置信号量signal为1
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                System.out.print(str.charAt(i));
                signal = 1;
                break;
            }
        }
        //如果信号量为零，证明全部为重复字符
        if (signal == 0) {
            System.out.println(-1);
        }
        //每读取一行输出一个回车
    }


    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * @param args
     */
//    public static void main(String[] args) {
//
//        System.out.println(firstOnceChar("ababac"));
//        System.out.println(firstOnceChar01("ababac"));
//    }


    /**
     * 找字符流中第一次出现一次的字符
     */
    int[] arr = new int[256];
    String s = "";

    public void Insert(char ch) {
        s += ch;
        arr[ch]++;
    }

    public char FirstAppearingOnce() {
        char[] str = s.toCharArray();
        for (char c : str) {
            if (arr[c] == 1)
                return c;
        }
        return '#';
    }

    /**
     * 找字符串里第一次出现的字符
     *
     * @param s
     * @return
     */
    public static char firstOnceChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c,0) + 1);
            }
        }
        for (char c : chars) {
            if (map.get(c) == 1)
                return c;
        }
        return ' ';
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     *
     * @param s
     * @return
     */
    public static int firstOnceChar01(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int i = 0;
        for (char c : chars) {
            if (map.get(c) == 1)
                return i;
            i++;
        }
        return -1;
    }
}

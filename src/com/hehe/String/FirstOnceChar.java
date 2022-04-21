package com.hehe.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 找出字符串中 第一次只出现一次的字符
 */
public class FirstOnceChar {
    public static void main(String[] args) {

        System.out.println(FirstUniqChar("abbbsd"));
        System.out.println(FirstUniqChar01("abbbsd"));

        System.out.println(FirstUniqChar("abbbsdjdhfkahkhaiudiqwdd"));
        System.out.println(FirstUniqChar01("abbbsdjdhfkahkhaiudiqwdd"));


    }

    private static char FirstUniqChar01(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return str.charAt(i);
        }
//错误解法 Map不保证有序
//        for (Character c : map.keySet()) {
//            if(map.get(c) == 1)
//                return c;
//        }

        return ' ';
    }

    /**
     * 遍历字符串过程中 如果某个字符的indexOf 和 lastIndexOf 相等，那就是单个字符
     *
     * @param str
     * @return
     */
    private static char FirstUniqChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                return str.charAt(i);
            }
        }
        return ' ';
    }


}

package com.hehe.String;

import java.util.HashMap;
import java.util.Map;

public class FirstOnceChar_easy {
    public static void main(String[] args) {

        System.out.println(firstOnceChar("ababac"));
        System.out.println(firstOnceChar01("ababac"));
    }

    /**
     * 找字符串里第一次出现的字符
     * @param s
     * @return
     */
    public static char firstOnceChar(String s){
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c : chars){
            if (map.get(c) == 1)
                return c;
        }
        return ' ';
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     * @param s
     * @return
     */
    public static int firstOnceChar01(String s){
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int i = 0;
        for(char c : chars){
            if (map.get(c) == 1)
                return i;
            i++;
        }
        return -1;
    }
}

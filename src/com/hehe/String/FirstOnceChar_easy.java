package com.hehe.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 找字符串里第一次出现的字符
 *
 */
public class FirstOnceChar_easy {
    public static void main(String[] args) {

        System.out.println(firstOnceChar("ababac"));
    }

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
}

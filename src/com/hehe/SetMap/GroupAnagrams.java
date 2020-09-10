package com.hehe.SetMap;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String s = "123";
        char[] c = s.toCharArray();
        System.out.println(c.toString());
        System.out.println(String.valueOf(c));

        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> ll : list){
            for(String ss : ll)
                System.out.print(ss + " ");
            System.out.println();
        }


    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String tmp = String.valueOf(c);
            if(!map.containsKey(tmp))  //String.valueOf(c)
                map.put(tmp,new ArrayList<>());
            map.get(tmp).add(s);
        }
        return new ArrayList(map.values());
    }
}

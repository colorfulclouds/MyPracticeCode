package com.tmp;

import java.util.HashMap;

public class Main2 {
   // 判断s2是否包含s1的所有字符
    public static boolean contains(String s1,String s2){
        int index = 0;
        int len = s1.length();
        for (int i = 0; i < s2.length() - s1.length()+1; i++) {
            if(valid(s1,s2.substring(i,i+len)))
                return true;
        }
        return false;
    }

    private static boolean valid(String s1, String s2) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char c : s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(char c : s2.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        for (char c : map1.keySet()){
            if(map1.get(c) != map2.get(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 ="abc";
        String s2 = "jgcbaslh";
        String s3 = "abjgslh";
        System.out.println(contains(s1,s2));
        System.out.println(contains(s1,s3));
    }
}

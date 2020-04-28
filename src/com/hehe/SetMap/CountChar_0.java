package com.hehe.SetMap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountChar_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> hs = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            hs.add(str.charAt(i));
        }
        System.out.println(hs.size());


    }
}

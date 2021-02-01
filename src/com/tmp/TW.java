package com.tmp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TW {
    public static void main(String[] args) {
        System.out.println("=========================No.1=====================");
//        String s = "Asas";
//        char[] ch = {'A','s'};
//        System.out.println(MoveChars(s,ch));
        System.out.println("=========================No.1=====================");

        System.out.println("=========================No.2=====================");
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {1,2,3,4,5,6};
        int[] res = swapClose(arr);
        int[] res1 = swapClose(arr1);
        System.out.println("=========================No.2=====================");

        System.out.println("=========================No.3=====================");
        allRes("10");
        allRes("23");
        allRes("14");
        allRes("89");
        allRes("79");
        System.out.println("=========================No.3=====================");

    }

    public static void allRes(String s){
        if (s == null || s.length() == 0) {
            return;
        }
        if(s.charAt(0) == '0' || s.charAt(0) == '1' || s.charAt(1) == '0' || s.charAt(1) == '1'){
            System.out.println("N/A");
            return;
        }

        String[] letter_map = {
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
//        if(s.charAt(0)-2 >=0 &&)
        int a = s.charAt(0)-2;
        int b = s.charAt(1)-2;
        String aa = letter_map[s.charAt(0)-'2'];
        String bb = letter_map[s.charAt(1)-'2'];
        for (int i = 0; i < aa.length(); i++) {
            for (int j = 0; j < bb.length(); j++) {
                int x = aa.charAt(i);
                System.out.print(aa.charAt(i)+""+ bb.charAt(j)+" ");
            }
        }
    }

    public static  int[] swapClose(int[] arr){
        for (int i = 0; i+1<arr.length; i+=2) {
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
        return arr;
    }

    public static StringBuilder moveChars(String s,char[] ch){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if(ch[i] == s.charAt(j))
                    sb.replace(j,j+1,"_");
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)!='_')
                //System.out.println(sb.charAt(i));
                res.append(sb.charAt(i));
        }
        return res;
    }



}

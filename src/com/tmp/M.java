package com.tmp;

import java.util.*;

public class M {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        if(x < 0)
//            System.out.println(x*x);
//        else if(x>0 && x<10)
//            System.out.println(Math.sqrt(x));
//        else
//            System.out.println(x);
//    }
//    public static String reverse(String s) {
//        String[] words = s.split("\\s+");
//        StringBuilder sb = new StringBuilder();
//        for (int i = words.length - 1; i >= 0; i--) {
//            sb.append(words[i]+" ");
//        }
//        return sb.toString().trim();
//    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = 0;
        int j = s.length()-1;
//        if(s.length() == 0)
//            return;
        while(i <j){
           if(s.charAt(i) != s.charAt(j)){
               System.out.println(false);
               return;
           }
           i++;
           j--;
        }
        System.out.println(true);
    }
}
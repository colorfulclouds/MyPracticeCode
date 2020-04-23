package com.hehe.ArrayAndList;

import java.util.HashSet;
import java.util.Scanner;


public class ReverseStringNoRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
//        reverse(s);
        test(s);

        //52ms的方法

//        HashSet<Integer> set = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length()-1; i >= 0; i--) {
////            System.out.print(s.charAt(i));
//            String si = String.valueOf(s.charAt(i));
//            Integer isi = Integer.parseInt(si);
//            while(!set.contains(isi)){
//                set.add(isi);
//                sb.append(si);
//            }
//        }
//        System.out.println(Integer.parseInt(sb.toString()));


    }

    //36ms的方法
    public static void reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int arr1[] = new int[10];

        for (int i = s.length() - 1; i >= 0; i--) {
            if (arr1[s.charAt(i) - 48] == 0) {  //字符’0’的ascii码是48，数字0的值是0
                sb.append(s.charAt(i));
                arr1[s.charAt(i) - 48]++;
            }
        }

        System.out.println(Integer.parseInt(sb.toString()));
    }


    //测试输出
//    输入    1000
//    输出    1000
//            1000
    public static void test(String s){
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) - 48);
        }
    }



}

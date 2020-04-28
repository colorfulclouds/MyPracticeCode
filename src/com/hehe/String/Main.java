package com.hehe.String;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    /**
     * 题目描述:
     * 给定n个字符串，请对n个字符串按照字典序排列。
     * 输入描述:
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     * 输出描述:
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     *
     * TreeSet是一个包含有序的且没有重复元素的集合(本题通过率 60%)  --不能用！！！
     * Collection
     * @param args
     */
//    int n = Integer.parseInt(sc.nextLine());
//    ArrayList<String> list = new ArrayList<>();
//        while (--n >= 0 && sc.hasNextLine()) {
//        String s = sc.nextLine();
//        list.add(s);
//    }
//        Collections.sort(list);
//        for (String s : list) {
//        System.out.println(s);
//    }

    //DROP的方法
//        TreeSet<String> ts = new TreeSet<>();
//        while (n!=0) {
//            String s = sc.nextLine();
//            ts.add(s);
//            n--;
//        }
//        for(String s : ts){
//            System.out.println(s);
//        }



    //浮点数取整：小数点后数字大于5的要向前进1
//        float flt = sc.nextFloat();
//        int res = (int)(flt+0.5);
//        System.out.println(res);

    //数字符串中指定字符的个数
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine().toUpperCase();
//        int count = 0;
//        String str1 = sc.nextLine().toUpperCase();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == str1.charAt(0)){
//                count++;
//            }
//        }
//        System.out.println(count);
}

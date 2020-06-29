package com.hehe.Test;

import java.util.Arrays;

public class test {



    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 10;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        //------------------------------------------------------------------------------------

        String s1 = "123";
        String s2 = "123";
        String s3 = "ab";
        String s4 = new String("ab");


        /**
         * 当调用 String 类的 intern（）方法时，若常量池中已经包含一个等于此 String 对象的字符串
         * （用 Object 的 equals 方法确定），则返回池中的字符串，否则将此 String 对象添加到池中，
         * 并返回此 String 对象在常量池中的引用
         *
         * jdk1.6 常量池在方法区 jdk1.7后在堆中
         *
         * 因为jdk7中intern方法是（在常量区找不到该字符串时）将该字符串对象在堆里的引用注册到常量区，
         * 以后使用相同字面量（双引号形式）声明的字符串对象都指向该地址，也就是该字符串在堆中的地址。
         * 所以，调用s3的intern方法后返回的引用就是s3本身的引用，而使用字面量声明的s4也是指向这个引用的，
         * 所以这两个地址相同
         */

        String s5 = new String("ab") + new String("cd");
        s5.intern();
        String s6 = "abcd";

        System.out.println(s1 == s2); //true
        System.out.println(s3 == s4); //false
        System.out.println(s5 == s6); //true
        //------------------------------------------------------------------------------------
//        /**
//         * Arrays.binarySearch 的测试
//         */
//        int[] nums1 = {1, 3, 5, 2, 4};
//        int[] nums2 = {2, 6, 5, 4, 9, 1, 7};
//        Arrays.sort(nums2);
//        int index1 = Arrays.binarySearch(nums2, nums1[0]);   //应该返回0
//        int index2 = Arrays.binarySearch(nums2, 1);   //应该返回0
//        int index3 = Arrays.binarySearch(nums2, nums1[4]);   //3
//        int index4 = Arrays.binarySearch(nums2, 4);   //3
//        System.out.println(index1);
//        System.out.println(index2);
//        System.out.println(index3);
//        System.out.println(index4);
    }


}

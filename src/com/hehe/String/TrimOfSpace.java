package com.hehe.String;

public class TrimOfSpace {

    public static void main(String[] args) {

        String string = "0.0.0.0          0.255.255.255   IANA保留地址      CZ88.NET";
        String string2 = "0.0.0.0    ?? 0.255.255.255   IANA保留地址       CZ88.NET";
        //字符串的? 替换的正则表达式

//		System.out.println(string);

        String test = string.replaceAll(" +", "==");   //将多个空格:（" +"） ,替换成一个空格
        //==================================== 正则有点问题 =======================================
//        String test2 = string2.replaceAll("[^%&',;=?$\x22]+", " ");

        System.out.println(test);
//        System.out.println(test2);

//        string = test;
//        String[] str = string.split(" ");
//
//        for (String s : str)
//            System.out.println(s);
    }
}

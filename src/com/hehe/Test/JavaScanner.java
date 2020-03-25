package com.hehe.Test;

import java.io.IOException;
import java.util.Scanner;

//java输入使用Scanner,支持字符，字符串，整数
public class JavaScanner {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        next()方法是遇空格和Tab键结束。
//        nextLine()可以接收空格或者tab键，其输入以enter键结束。
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();   //sc.nextLine()
        System.out.println("第二次输入你的姓名：");
        String name2 = sc.next();     //sc.next()
        System.out.println(name2);

        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();     //sc.nextInt()

        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();    // sc.nextFloat()

        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);

        System.out.println("===============注释上面的  运行下面的==================");

        //System的输入
//        System.out.println(System.in.read());       //System.in.read()  输出的是Ascii码
        System.out.println((char) System.in.read());

//        5
//        53


    }

}

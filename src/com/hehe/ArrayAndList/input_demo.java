package com.hehe.ArrayAndList;

import java.util.Scanner;

public class input_demo {
        public static void main(String[] args) {

            int[] a = new int[9];
            String s = "12345";
            String s2 = "a\n"; // "\0" 也占一位
            String s3 =" ";
//            System.out.println(a.length);
//            System.out.println(s.length());
            System.out.println(s2.length());
            System.out.println(s3.length());

            /**
             * 1 2 3 4
             * 1
             * 2
             * 3
             * 4
             */
//            Scanner sc = new Scanner(System.in);
//            while(sc.hasNext()) {
//                String str = sc.next();
//                System.out.println(str);
//            }
//            sc.close();


            //while(sc.hasNext()) 里面处理的全局变量无法使用 只能在循环里面输出
//            Scanner sc = new Scanner(System.in);
//            int a =1;
//            while(sc.hasNext()){
//                String s = sc.nextLine();
//                a+=1;
//                System.out.println(s + ": a ");
//            }
//            System.out.println(a);


//            while (true) {
//                String nextLine = scanner.nextLine();
//                if (nextLine == null || nextLine.trim().length() == 0) {
//                    System.out.println("empty, break.");
//                    break;
//                }
//                System.out.println(nextLine);
//            }
        }
    }

package com.hehe.Classic;


import java.util.Scanner;

public class ___10To2andCount1 {

    public static void main(String[] args) {
        //___10To2andCount1
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        while(n>0){
            if((n&1)>0){  //与1的与操作
                count++;
            }
            n=n>>1;  //右移
        }
        System.out.println(count);

        System.out.println("=====测试java自带的进制转换=====");

        System.out.println(Integer.toString(10,3));  //java自带的10进制转换成其他任意进制的方法
        System.out.println(Integer.toString(10,2));
        System.out.println(Integer.toString(10,8));
        System.out.println(Integer.toString(10,16));

        System.out.println(Integer.parseInt("10",2)); //java自带的其他任意进制转换成10进制的方法
        System.out.println(Integer.parseInt("10",3));
        System.out.println(Integer.parseInt("10",8));
        System.out.println(Integer.parseInt("10",16));

        System.out.println("=====测试java自带的进制转换=====");

        /**
         * 火星文三进制
         */
//        String s = fun(3, 10);  //自定义的10进制转换成其他任意进制的方法
////        String s = Integer.toString(10,3);  //java自带的10进制转换成其他任意进制的方法
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '0')
//                sb.append("@");
//            if (s.charAt(i) == '1')
//                sb.append("5");
//            if (s.charAt(i) == '2')
//                sb.append("8");
//
//        }
//        System.out.println(sb);

    }


    /**
     * 十进制转换为 n 进制
     *
     * @param n
     * @param num
     * @return
     */
    public static String fun(int n, int num) {
        // n 表示目标进制, num 要转换的值
        String str = "";
        int yushu;      // 保存余数
        int shang = num;      // 保存商
        while (shang > 0) {
            yushu = shang % n;
            shang = shang / n;

            // 10-15 -> a-f
            if (yushu > 9) {
                str = (char) ('a' + (yushu - 10)) + str;
            } else {
                str = yushu + str;
            }
        }
        return str;
    }


    //Drop 60%
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int input = Integer.parseInt(sc.nextLine());
//        int count = 0;
//        while(input/2 != 1){
//            if(input%2 == 1)
//                count++;
//            input/=2;
//        }
//        System.out.println(count+1);
//
//
//    }
}

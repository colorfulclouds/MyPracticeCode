package com.hehe.Classic;

import java.util.Scanner;

//进制转换：16 to 2
public class ___16To10Binary {

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str = sc.nextLine();
//            System.out.println(fun(str.substring(2)));
//        }

        String s = "10";
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next().substring(2);
            System.out.println(Integer.parseInt(str,16));   //parseInt 把16进制的字符串 解析成 int类型
            System.out.println(Integer.parseInt("232")); // 将字符串"232"  转换为整型

            System.out.println(Integer.parseInt(s,2));  //s为二进制的"10"  将其转换为整型
            System.out.println(Integer.parseInt(s,8));  //s为八进制的"10"  将其转换为整型

//            十进制  十六进制  二进制 八进制

        }
    }


    /**
     * 十进制转二进制
     * @param num
     * @return
     */
    public static String MethodBinary(int num) {
        String a = "";//用字符串拼接
        while (num != 0) {//利用十进制转二进制除2法
            a = num % 2 + a;
            num = num / 2;
        }
        return a;
    }

    //进制转换：16 to 2(未看)
    public static int fun(String s){
        int n=0;
        int count= 0;
        int temp = 0;
        char ch;

        while(count<s.length()){
            ch = s.charAt(s.length()-count-1);
            if(ch>='0'&&ch<='9'){
                temp = ch-'0';
            }else if(ch>='A'&&ch<='Z'){
                temp = ch-'A'+10;
            }else if(ch>='a'&&ch<='z'){
                temp = ch-'a'+10;
            }else{
                break;
            }
            n += temp*Math.pow(16,count);
            count++;
        }

        return n;
    }
}

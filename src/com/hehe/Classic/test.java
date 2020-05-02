package com.hehe.Classic;

public class test {
    public static void main(String[] args) {
        System.out.println(MethodBinary(137 & 224));
    }

    public static String MethodBinary(int num){
        String a = "";//用字符串拼接
        while(num!=0) {//利用十进制转二进制除2法
            a=num%2+a;
            num=num/2;
        }
        return a;
    }
}

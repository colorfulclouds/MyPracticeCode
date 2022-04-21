package com.hehe.Classic;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNumOfN {
    public static void main(String[] args) {

        System.out.println(sum(10));
        System.out.println(sum(3));
    }

    public static int sum(int n) {
        boolean b = n > 1 && (n += sum(n - 1)) > 0;
        return n;
    }
}

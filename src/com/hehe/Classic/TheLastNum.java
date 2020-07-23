package com.hehe.Classic;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 递归或者逆推
 */
public class TheLastNum {

    public static void main(String[] args) {

//        System.out.println(lastRemaining(1,3));
//        System.out.println(lastRemaining(2,3));
//        System.out.println(lastRemaining(3,3));
//        System.out.println(lastRemaining(4,3));
        System.out.println(lastRemaining(5,3));
        System.out.println(fun01(5,3));

    }

    /**
     * 1、
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n,int m){
        return fun(n,m);
    }

    public static int fun(int n, int m) {
        if(n == 1)
            return 0;
        int x = fun(n -1,m);
        return (x + m ) % n;
    }

    /**
     * 2、
     * @param n
     * @param m
     * @return
     */
    public static int fun01(int n, int m) {
        int x = 0;
        for (int i = 1; i < n ; i++) {
            x =( x + m) % (i + 1);
        }
        return x;
    }

}

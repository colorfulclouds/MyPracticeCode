package com.hehe.Classic;

//package Jianzhi_Offer;
/*
 * 非递归
 * 从下往上计算
 * 时间复杂度是O(n) *
 * */
public class Fibonacci_jz {
    public static long FibonacciRecursive(int n) {
        if (n <= 0)
            return 0;
        if(n == 1)
            return 1;
        return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
    }

    public long Fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];
        long fib1 = 1;
        long fib2 = 0;
        long fibN = 0;
        for (int i = 2; i <= n; ++i) {
            fibN = fib1 + fib2;
            fib2 = fib1;
            fib1 = fibN;
        }
        return fibN;
    }

    /*
     * n =80
     * 23416728348467685
     *
     * */

    public static void main(String[] args) {
//        long fib = new Fibonacci_jz().Fibonacci(6);
//        System.out.println(fib);
        System.out.println(FibonacciRecursive(80));;
    }

}
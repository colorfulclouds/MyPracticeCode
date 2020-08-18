package com.hehe.Classic;


public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
        System.out.println(Fibonacci01(10));


    }

    public static long Fibonacci(int n) { //注意 long
        long[] f = {0, 1, n};
        for (int i = 2; i < n; i++) {
            f[2] = f[0] + f[1];
            f[0] = f[1];
            f[1] = f[2];
        }
        return f[2];
    }

    public static long Fibonacci01(int n) {
        if (n < 2)
            return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}

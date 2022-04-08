package com.hehe.Classic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 求最大公约数 也即最大公因子
 *
 * 最大公约数 * 最小公倍数 = 原两数乘积
 * 互质的两个数 相乘等于最小公倍数
 * 大数翻倍法
 */
public class Gongyueshu {

    public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);

//		String nm = "12";
//		System.out.println(System.getProperties());
//		System.out.println(Integer.getInteger("os.name"));

        System.out.println("============辗转相减法求最大公约数=================");
        System.out.println(equalGCD(376868962, 378787860));
        System.out.println(equalGCD(4, 2));
        System.out.println(equalGCD(8, 12));
        System.out.println(equalGCD(18, 12));

        System.out.println("============暴力找约数=======long time==========");
        System.out.println(getFactor(376868962));
        System.out.println(getFactor(4));
        System.out.println(getFactor(8));
        System.out.println(getFactor(18));

        System.out.println(188434481*2);
//
        System.out.println("============通过暴力找约数的方法，求出两数的所有约数，求交集，再求最大值=====longer time=======");
        System.out.println(PrimeGCD(376868962, 378787860));
        System.out.println(PrimeGCD(4, 2));
        System.out.println(PrimeGCD(8, 12));
        System.out.println(PrimeGCD(18, 12));

        System.out.println("============辗转相减法求最大公约数=================");
        System.out.println(GCD(376868962, 378787860));
        System.out.println(GCD(4, 2));
        System.out.println(GCD(8, 12));
        System.out.println(GCD(18, 12));

    }

    //辗转取余法求最大公约数
    public static int GCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }


    //通过暴力找约数的方法，求出两数的所有约数，求交集，再求最大值
    public static int PrimeGCD(int m, int n) {
        int result = 1;
        Set<Integer> set1 = getFactor(m);
        Set<Integer> set2 = getFactor(n);
        // 取交集
        set1.retainAll(set2);
        // 取最大
        result = Collections.max(set1);
        return result;
    }

    //暴力找约数
    private static Set<Integer> getFactor(int m) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 2; i <= m; i++) {
            if (m % i == 0) {
                set.add(i);
            }
        }
        return set;

    }

    //辗转相减法求最大公约数
    public static Long equalGCD(long m, long n) {
        while (m != n) {
            if (m > n)
                m -= n;
            else
                n -= m;
        }
        return (long) m;
    }
}

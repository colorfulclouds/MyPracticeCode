package com.hehe.Classic;
/*
* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
*
* */
public class IntReverse {
    public static int reverse(int x) {
        int res = 0;
        int _x = x;
        while (_x != 0) {
            res = res * 10 + (_x % 10);
            _x /= 10;
        }
        if ((res > Math.pow(2, 31) - 1) || (res < (-1) * Math.pow(2, 31)))
            return 0;
        return res;
    }

    public static int reverse01(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        if ((res > Math.pow(2, 31) - 1) || (res < (-1) * Math.pow(2, 31)))
            return 0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(123));
        System.out.println(reverse(120));
        System.out.println(reverse01(-123));
        System.out.println(reverse01(123));
        System.out.println(reverse01(120));

    }
}

/*32位既是整数

 * 基本数据类型
 * 整型：byte（16）,short（16） int（32） long（64）
 * 浮点型：float（32）,double（64）
 * 逻辑类型：boolean（1）
 * 字符型：char（16）
 * */


//成功
//显示详情
//执行用时 : 6 ms, 在Reverse Integer的Java提交中击败了98.40% 的用户
//内存消耗 : 33.2 MB, 在Reverse Integer的Java提交中击败了24.75% 的用户

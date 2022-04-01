package com.hehe.Classic;


import java.util.Scanner;

/**
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * <p>
 * 数据范围：数据组数：1\le t\le 5\1≤t≤5 ，1\le n\le 500000\1≤n≤500000
 * 进阶：时间复杂度：O(logn)\O(logn) ，空间复杂度：O(1)\O(1)
 * 输入描述：
 * 输入一个int类型数字
 * <p>
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 * <p>
 * 示例1
 * 输入：
 * 200
 * 复制
 * 输出：
 * 2
 * 复制
 * 说明：
 * 200的二进制表示是11001000，最多有2个连续的1。
 */
public class Binary_NumberOfLongestBit1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            int count = 0;
            for (; n != 0; count++) //统计能够运算多少次
                n &= n << 1; //与自己左移一位后比较
            System.out.println(count);
        }
    }

}


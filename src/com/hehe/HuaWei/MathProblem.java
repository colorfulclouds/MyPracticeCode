package com.hehe.HuaWei;

import java.util.Scanner;

/**
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1\le m\le 100\1≤m≤100
 * 进阶：时间复杂度：O(m)\O(m) ，空间复杂度：O(1)\O(1)
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出分解后的string
 *
 * 示例1
 * 输入：
 * 6
 * 复制
 * 输出：
 * 31+33+35+37+39+41
 */
public class MathProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            int double_num = num * num;
            StringBuilder sb = new StringBuilder();
            if (num % 2 == 0) {
                int front = double_num - 1;
                int back = double_num + 1;
                StringBuilder temp = new StringBuilder(front + "+").append(back);
                for (int i = 0; i < num / 2 - 1; i++) {
                    front -= 2;
                    back += 2;
                    temp = new StringBuilder(front + "+").append(temp).append("+" + back);
                }
                sb = temp;
            } else {
                int front = double_num - 2;
                int back = double_num + 2;
                StringBuilder temp = new StringBuilder(front + "+").append(double_num).append("+" + back);
                for (int i = 0; i < num / 2 - 1; i++) {
                    front -= 2;
                    back += 2;
                    temp = new StringBuilder(front + "+").append(temp).append("+" + back);
                }
                sb = temp;
            }
            System.out.println(sb);
            System.out.println(Math.pow(num, 3));
        }
    }
}

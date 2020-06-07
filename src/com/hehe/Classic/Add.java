package com.hehe.Classic;


/**写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 二进制运算中，异或，留下了加法不进位的信息，而与运算，则留下了进位信息，将进位信息左移到位，又来了，加法，出现了递归。
 */
public class Add {
    public static int add(int a, int b) {
        return b==0? a : add(a^b, (a&b)<<1);
    }

    public static void main(String[] args) {
        System.out.println(add(5,7));
    }
}

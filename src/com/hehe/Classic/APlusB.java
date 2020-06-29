package com.hehe.Classic;

public class APlusB {
    public static void main(String[] args) {
        System.out.println(aplusb(10,12));
    }

    /**
     * 不使用运算符进行a+b操作
     * a^b; 得到不含进位之和
     * (a&b)<<1; 进位
     * 只要进位不为零，则迭代；否则返回
     *
     * @param a
     * @param b
     * @return
     */
    public static int aplusb(int a, int b) {
        int sum_without_carry, carry;
        sum_without_carry = a ^ b; //没有进位的和
        carry = (a & b) << 1;// 进位
        if (carry == 0) return sum_without_carry;
        else
            return aplusb(sum_without_carry, carry);
    }
}

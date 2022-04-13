package com.hehe.Classic;

public class Operate2Num {
    public static void main(String[] args) {

        int num1 = 1, num2 = 2;
        exchange(num1, num2);
        System.out.println("+++++++++++++实际外边的数字+++++++++");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println("==================aplusb===============");
        System.out.println(aplusb(3, 5));

    }

    /**
     * 交换两个数
     *
     * @param num1
     * @param num2
     */
    public static void exchange(int num1, int num2) {
        int tmp = num1 ^ num2;
        num1 = tmp ^ num1;
        num2 = tmp ^ num2;
        System.out.print(num1 + " ");
        System.out.println(num2);
    }

    public static int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
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

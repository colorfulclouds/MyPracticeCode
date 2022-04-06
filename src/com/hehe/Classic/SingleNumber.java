package com.hehe.Classic;

/**
 * 求出数组中出现一次的一个或者两个数字
 * 1、一组数据中 一个数字出现一次 其他数字均出现两次
 * 2、一组数据中 两个数字出现一次 其他数字均出现两次
 * 3、一组数据中，一个数字出现一次，其它数字均出现三次
 * <p>
 * 注：任何数和自己异或结果为 0
 */
public class SingleNumber {
    public static void main(String[] args) {
        //1、一组数据中 一个数字出现一次 其他数字均出现两次 全员亦或即可
        int[] num = {2, 2, 3, 4, 4};

        int res = 0;
        for (int i = 0; i < num.length; i++) {
            res ^= num[i];
        }
        System.out.println(res);

        //=============================================================
        //2、一组数据中 两个数字出现一次 其他数字均出现两次 ：分组
        int[] num1 = {4, 2, 4, 6};
        int[] res1 = singleNumbers(num1);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + " ");
        }

        System.out.println();
        //=============================================================

        //3、一组数据中，一个数字出现一次，其它数字均出现三次：按位加和，除3取余得只出现一次的那个数字
        int[] num2 = {4, 2, 4, 4};
        System.out.println(singleNumber01(num2));

    }

    /**
     *有限状态自动机 ：被三除取余的结果有三种 ：00 01 10
     * @param nums
     * @return
     */
    public static int singleNumber01(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }



    /**
     * 分组组内全员亦或操作
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int res = 0;

        for (int num : nums) { //全员亦或 最后的结果等同于两个只出现一次的亦或结果
            res ^= num;
        }

        //获得 res 中最低位的1
        int mask = 1;

        //mask = res & (-res) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while ((res & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {  //根据掩码分组
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}

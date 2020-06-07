package com.hehe.Classic;

/**求出数组中出现一次的一个或者两个数字
 * 1、一组数据中 一个数字出现一次 其他数字均出现两次
 * 2、一组数据中 两个数字出现一次 其他数字均出现两次
 *
 * 注：任何数和自己亦或结果为 0
 */
public class SingleNumber {
    public static void main(String[] args) {
        //1、一组数据中 一个数字出现一次 其他数字均出现两次 全员亦或即可
        int[] num = {2, 2, 3, 4, 4};

        //======================1、=======================================
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            res ^= num[i];
        }
        //=============================================================

        System.out.println(res);

        //2、一组数据中 两个数字出现一次 其他数字均出现两次 ：分组
        int[] num1 = {4,2,4,6};
        int[] res1 = singleNumbers(num1);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(res1[i]);
        }

    }

    /**分组组内全员亦或操作
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int res = 0;

        for(int num: nums) {
            res ^= num;
        }

        //获得 res 中最低位的1
        int mask = 1;

        //mask = res & (-res) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((res & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}

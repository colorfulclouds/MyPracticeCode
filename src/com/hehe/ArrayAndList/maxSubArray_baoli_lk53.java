package com.hehe.ArrayAndList;


//最大和的连续子数组（暴力解法）

/**
 *  给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *  *
 *  * 子序列（原序列中不连在一起的）
 *  * 子串（原序列中连在一起的）------连续子数组
 *  *
 *  * 示例:
 *  * 输入：[-2,1,-3,4,-1,2,1,-5,4]
 *  * 输出：6
 *  * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class maxSubArray_baoli_lk53 {

    public static void main(String[] args) {
        int[] nums = {-2,4,-1,2,1,1,-3,-5,4};
        int res = maxSubArray_baoli_lk53(nums);
        System.out.println(res);
    }

    public static int maxSubArray_baoli_lk53(int[] nums){
        int n = nums.length;
        int res_max = nums[0];
        int cur_max = nums[0];

        for (int i = 1; i < n; i++) {
            cur_max = Math.max(nums[i],cur_max + nums[i]);
//            cur_max = cur_max + nums[i];   //此种写法没有考虑单个值最大的情况
            res_max = Math.max(cur_max,res_max);
        }
        return res_max;
    }


}

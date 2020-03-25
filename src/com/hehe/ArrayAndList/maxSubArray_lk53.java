package com.hehe.ArrayAndList;

//import com.sun.javafx.image.IntPixelGetter;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子序列（原序列中不连在一起的）
 * 子串（原序列中连在一起的）------连续子数组
 *
 * 示例:
 * 输入：[-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 * 输入: [-2,4,-1,2,1,1,-3,-5,4],
 * 输出: 7
 * 解释: 连续子数组 [4,-1,2,1,1]的和最大，为 7。
 *
 *
 * 官方算法解释在最下面
 */

public class maxSubArray_lk53 {
    public static void main(String[] args) {
        int[] nums = {-2,4,-1,2,1,1,-3,-5,4};
        int res = maxSubArray_lk53(nums);
        System.out.println(res);
    }

    public static int maxSubArray_lk53(int[] nums) {
        int res = process(nums, 0, nums.length - 1);
        return res;
    }

    //public?
    private static int process(int[] nums, int left, int right) {
        //处理前的特殊判断
        if (left == right) return nums[left];

        //进行递归，先解决子问题再返回结果结果上一级的子问题
        int p = (left + right) / 2; //奇偶
        int left_max = process(nums, left, p);
        int right_max = process(nums, p + 1, right);
        int combine_max = combineMax(nums, left, right, p);

        return Math.max(Math.max(left_max, right_max), combine_max);
    }

    private static int combineMax(int[] nums, int left, int right, int p) {
        //合并前的判断
        if (left == right) return nums[left];

        int leftSubSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = p; i > left-1; --i) {  //为了能将前后两部分拼接产生最大的子串，所以从中间开始往左边蔓延添加
            curSum += nums[i];
            leftSubSum = Math.max(leftSubSum,curSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        curSum = 0;   //置零 复用
        for (int i = p + 1; i < right + 1; ++i) {
            curSum += nums[i];
            rightSubSum = Math.max(rightSubSum,curSum);
        }

        return leftSubSum + rightSubSum;
    }

}


//    若 n==1，返回此元素。
//        left_sum 为最大子数组前 n/2 个元素，在索引为 (left + right) / 2 的元素属于左子数组。
//        right_sum 为最大子数组的右子数组，为最后 n/2 的元素。
//        cross_sum 是包含左右子数组且含索引 (left + right) / 2 的最大值。
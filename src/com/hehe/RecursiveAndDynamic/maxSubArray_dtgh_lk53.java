package com.hehe.RecursiveAndDynamic;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * *
 * * 子序列（原序列中不连在一起的）
 * * 子串（原序列中连在一起的）------连续子数组
 * *
 * * 示例:
 * * 输入：[-2,1,-3,4,-1,2,1,-5,4]
 * * 输出：6
 * * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */

import java.util.LinkedList;
import java.util.List;

/**最大和的连续子数组和(动态规划)
 * 动态规划转移方程
 * f(i) = max { f(i−1) + ai ,ai}
 *
 * f(i) 只与 f(i-1) 有关,用cur_max保存 当前滚动数组 的最大值，用res_max来保存历史滚动数组的最大值
 * 因为滚动过程中 可能增益 也可能衰减
 *
 */

public class maxSubArray_dtgh_lk53 {

    public static void main(String[] args) {
//        int[] nums = {-2,4,-1,2,1,1,-3,-5,4};
        int[] nums = {1, -2, -3, -4, 9, 1};

        int[] nums1 = {1, 2, 3, 4, 9, 1};
        int[] nums2 = {-1, -2, -3, -4, -9, -1};
        int[] nums3 = {9, -2, 1, -4, -2, 3};
        int[] nums4 = {3, -2, 3, -4, -2, -1};
        int[] nums5 = {-2,1,-3,4,-1,2,1,-5,4};

//        System.out.println(maxSubArray_dtgh_lk53(nums));
//        System.out.println(maxSubArray_dtgh_lk53(nums1));
//        System.out.println(maxSubArray_dtgh_lk53(nums2));
//        System.out.println(maxSubArray_dtgh_lk53(nums3));

//        System.out.println(maxSubArrayPlus_dtgh_lk53(nums));
//        System.out.println(maxSubArrayPlus_dtgh_lk53(nums3));


//        System.out.println(maxSubArray(nums5));
        System.out.println(maxSubArray01(nums5));
//        System.out.println(Sum(nums4));
    }

    /**
     * 最大的连续子数组和
     * @param nums
     * @return
     */
    public static int maxSubArray_dtgh_lk53(int[] nums) {
        int n = nums.length;
        int res_max = nums[0];
        int cur_max = nums[0];
        for (int i = 1; i < n; i++) {
            cur_max = Math.max(nums[i], cur_max + nums[i]);
//            cur_max = cur_max + nums[i];   //此种写法没有考虑单个值最大的情况
            res_max = Math.max(cur_max, res_max);
        }
        return res_max;
    }


    /**
     *求最大连续子序列和的连续子序列
     * hehe
     * zf_pdd_20200815
     * @param nums
     * @return
     */
    public static List maxSubArray(int[] nums) {
        int start = 0;
        int end = 0;

        int res_max = nums[0];
        int cur_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >= nums[i] + cur_max){
                start = i;
                end = i;
            }
            cur_max = Math.max(nums[i],nums[i] + cur_max);
            res_max = Math.max(cur_max,res_max);
            if(cur_max >= res_max)
                end = i;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = start; i <=end ; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    public static List maxSubArray01(int[] nums) {
        List<Integer> list = new LinkedList<>();
//        int res_max = nums[0];
//        int cur_max = nums[0];
//        list.add(nums[0]);
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] >= nums[i] + cur_max)
//                list.clear();
//            cur_max = Math.max(nums[i],nums[i] + cur_max);
//            res_max = Math.max(cur_max,res_max);
//            list.add(nums[i]);
//            if(cur_max >= res_max)
//                break;
//        }
        return list;
    }


    /**
     * 【错误的】求最大连续子序列和的连续子序列
     * zf
     * @param nums
     * @return
     */
    public static List<Integer> Sum(int[] nums) {
        if (nums == null || nums.length < 1)
            return new LinkedList<>();
        int res = nums[0];
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (res > 0){
                res += nums[i];
                list.add(nums[i]);
            }
            else {
                res = Math.max(res,nums[i]);
                if (res==nums[i]){
                    list.clear();
                }
            }
        }
        return list;
    }


}

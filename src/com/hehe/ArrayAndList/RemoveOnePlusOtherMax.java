package com.hehe.ArrayAndList;
/**
 * 删除数组(有正有负)的一个数 使其它的数字乘积最大
 * 分情况讨论
 */
public class RemoveOnePlusOtherMax {

    public static int findRemoveIndex(int[] nums) {

        // 统计负数的个数
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            // 有负数就+1
            if (nums[i] < 0) {
                negativeCount++;
            }
        }

        //根据不同的情况，选择要删除的元素
        int tempIndex = 0;

        if ((negativeCount & 1) == 1) {
            //情况1： 负数个数是奇数,就移除最大的负数
            for (int i = 1; i < nums.length; i++) {
//                int cur = nums[i];
                if (nums[i] < 0 && nums[i] < nums[tempIndex]) {
                    tempIndex = i;
                }
            }
            return tempIndex;

        } else {  //情况2： 负数个数是偶数
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]>=0 && nums[i] < nums[tempIndex]) {
                    tempIndex = i;
                }
            }
            return tempIndex;
        }

    }


    public static void main(String[] args) {
        int[] arr = {1,3,4,5,-1,0,-3};
        System.out.println(findRemoveIndex(arr));

    }
}
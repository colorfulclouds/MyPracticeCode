package com.hehe.ArrayAndList;

import java.util.Arrays;

/**
 * 查找第一个数组中元素是否在第二个数组中
 *   不在：返回-1
 *   在：返回第二个数组中右起第一个比它大的那个数字
 *
 *   注：复用了第一个数组的空间
 */

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {2, 6, 5, 4, 9, 1, 7};
        nums1 = nextGE(nums1, nums2);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
//		System.out.println(res.toString().toCharArray());
    }

    public static int[] nextGE(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int search;  //nums1中的元素在nums2中的下标

        for (int i = 0; i < length1; i++) {
//            search = Arrays.binarySearch(nums2, nums1[i]) + 1;
            search = find(nums2, nums1[i]) + 1;  //nums1[i] 中的每个元素遍历过之后就没有作用了，将遍历过的元素置为结果元素
            for (int j = search; j <= length2; j++) { // 没在第二个数组中找到该数字
                if (j == 0 || j == length2) {
                    nums1[i] = -1;
                    break;
                } else if (nums2[j] > nums1[i]) {
                    nums1[i] = nums2[j];
                    break;
                }
                //nums2[j] <= nums1[i] 的时候，都不进行操作，直接进入 i++

            }
        }
        return nums1;
    }


    public static int find(int[] nums, int number) {
        for (int i = 0; i < nums.length; i++)
            if (number == nums[i])
                return i;
        return -1;
    }

}

package com.hehe.Test;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {


        /**
         * Arrays.binarySearch 的测试
         */
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {2, 6, 5, 4, 9, 1, 7};
        int search2 = Arrays.binarySearch(nums2, nums1[0]);   //应该返回5
        int search = Arrays.binarySearch(nums2, nums1[4]);   //3
        int search1 = Arrays.binarySearch(nums2, 4);   //3
        System.out.println(search2);
        System.out.println(search);
        System.out.println(search1);
    }


}

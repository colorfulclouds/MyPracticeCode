package com.hehe.SortAndSearch;

import com.sun.scenario.animation.shared.ClipEnvelope;

public class BinarySearch {

    /**
     * 查找递增排序的数组中缺失的数
     *
     *
     * 二分查找：middle下标和元素相等时 继续右半部分的搜索
     * 如果不等 但前一个下标和元素相等 当前middle 即为所求 否则继续左半部分的查找
     * @param nums
     * @return
     */
    public static int MissingNumInSortedArray(int[] nums) {
        if (nums.length <= 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] != middle) {
                if (middle == 0 || middle - 1 == nums[middle - 1] || middle == nums.length)
                    return middle;
                right = middle - 1;
            } else
                left = middle + 1;

        }
//        if(left == nums.length)
//            return nums.length;
        return -1;
    }


    /**
     * 递归二分查找
     *
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (key > arr[mid]) {
            return recursionBinarySearch(arr, key, mid + 1, high);
        } else if (key < arr[mid]) {
            return recursionBinarySearch(arr, key, low, mid - 1);
        } else {
            return mid;
        }
    }

    /**
     * 非递归二分查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1, mid = 0; //初始化

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            mid = (high + low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};

        int key = 3;
        System.out.println(recursionBinarySearch(arr, key, 0, arr.length - 1));
        System.out.println(commonBinarySearch(arr, key));


//        int position = commonBinarySearch(arr, key);
//
//        if (position == -1) {
//            System.out.println("查找的是" + key + ",序列中没有该数！");
//        } else {
//            System.out.println("查找的是" + key + ",找到位置为：" + position);
//        }

        /**
         * MissingNumInSortedArray的测试用例
         */
        int[] arr01 = {0, 1, 2, 3, 5, 6};
        int[] arr02 = {1, 2, 3, 4, 5};
        System.out.println(MissingNumInSortedArray(arr01));
        System.out.println(MissingNumInSortedArray(arr02));
    }

}

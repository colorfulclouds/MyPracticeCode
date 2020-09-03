package com.hehe.SortAndSearch;

import com.sun.scenario.animation.shared.ClipEnvelope;

/**
 * 二分查找最多只与 [log2 n] + 1个元素比较   //下界
 * 完全二叉树的高度
 */
public class BinarySearch {

    /**
     * 输入排序数组：{1，2，3，3，3，4} 3
     * 输出：3
     * 3的个数有三个
     * <p>
     * 二分查找思想
     *
     * @param nums
     * @param k
     * @return
     */
    public static int timesOfNum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        if (len > 0) {
            int first = getFirstK(nums, 0, len-1, k);
            int last = getLastK(nums, 0, len-1, k);

            if (first > -1 && last > -1)
                res = last - first + 1;
        }
        return res;
    }

    /**
     * 查找第一个k的位置
     *递归
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    public static int getFirstK(int[] nums, int start, int end, int k) {
        if (start > end)
            return -1;

        int mid = (start + end) >> 1;

        if (nums[mid] == k) {
            if ((nums[mid - 1] != k && mid > 0) || mid == 0)
                return mid;
            else
                end = mid - 1;
        } else if (nums[mid] > k)
            end = mid - 1;
        else
            start = mid + 1;

        return getFirstK(nums, start, end, k);
    }

    /**
     * 查找最后一个k的位置
     * 递归
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    public static int getLastK(int[] nums, int start, int end, int k) {
        if (start > end)
            return -1;

        int mid = (start + end) >> 1;

        if (nums[mid] == k) {
            if ((nums[mid + 1] != k && mid < nums.length) || mid == nums.length)
                return mid;
            else
                start = mid + 1;
        } else if (nums[mid] > k)
            end = mid - 1;
        else
            start = mid + 1;

        return getLastK(nums, start, end, k);
    }


    /**
     * 查找递增排序的数组中缺失的数
     * <p>
     * <p>
     * 二分查找：middle下标和元素相等时 继续右半部分的搜索
     * 如果不等 但前一个下标和元素相等 当前middle 即为所求 否则继续左半部分的查找
     *
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

    /**
     * 查找第一个k的位置
     * 非递归
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    public static int getFirstK01(int[] arr, int low, int high, int key) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            if (key < arr[mid])
                high = mid - 1;
            else if (key > arr[mid])
                low = mid + 1;
            else if(arr[mid - 1] != key && mid > 0 && arr[mid] == key || mid == 0)
                return mid;
            else
                high = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 3;
//        System.out.println(recursionBinarySearch(arr, key, 0, arr.length - 1));
//        System.out.println(commonBinarySearch(arr, key));


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
//        System.out.println(MissingNumInSortedArray(arr01));
//        System.out.println(MissingNumInSortedArray(arr02));

        /**
         * test timesOfNum
         */
        int[] nums = {1, 2, 3, 3, 3, 4, 5};
        System.out.println(timesOfNum(nums,3));
        System.out.println("==============================");
        System.out.println(getFirstK01(nums,0,nums.length-1,3));


    }

}

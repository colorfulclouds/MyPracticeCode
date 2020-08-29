package com.hehe.ArrayAndList;

/**
 * jz-11
 * 排序数组 {1,2,3,4,5}
 * 旋转后的排序数组 {3,4,5,1,2}
 * 求旋转数组中的最小值
 */

public class MinInRotateArray {
    public static void main(String[] args) {
//        int[] arr = {3,4,5,0,1,2};
        int[] arr = {1, 1, 1, 1, 0, 1, 1}; //此种情况只能顺序查找，见注1

        System.out.println(minInRotateArray(arr));

    }

    /**
     * 旋转数组的最小值
     * 3 4 5 1 2
     * 1 2 3 4 5
     * @param arr
     * @return
     */
    public static int minInRotateArray(int[] arr) {
        if (arr == null || arr.length <= 0)
            return -1;
        int p1 = 0;
        int p2 = arr.length - 1;
        int mid = p1;
        while (p1 < p2) {
            if (p2 - p1 == 1) {
                mid = p2;
                break;
            }
            mid = (p1 + p2) / 2;
            if (arr[p1] == arr[p2] && arr[p2] == arr[mid])   //注 1
                return inOrderFindMin(arr, p1, p2);

            if (arr[p1] < arr[mid])  //同在前半部分的递增序列
                p1 = mid;
            else if (arr[p2] > arr[mid])  //同在后半部分的递增序列
                p2 = mid;
        }
        return arr[mid];
    }

    /**
     * 顺序查找最小值
     *
     * @param arr
     * @param p1
     * @param p2
     * @return
     */
    private static int inOrderFindMin(int[] arr, int p1, int p2) {
        int min = arr[p1];
        for (int i = p1 + 1; i < p2; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }



}

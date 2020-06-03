package com.hehe.ArrayAndList;

/**jz-11
 * 排序数组 {1,2,3,4,5}
 * 旋转后的排序数组 {3,4,5,1,2}
 * 求旋转数组中的最小值
 */

public class MinInRotateArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(minInRotateArray(arr));

    }

    public static int minInRotateArray(int[] arr) {
        if (arr == null || arr.length <= 0)
            return -1;
        int p1 = 0;
        int p2 = arr.length - 1;
        int mid = p1;
        while(p1<p2){
            if(p2-p1 == 1){
                mid = p2;
                break;
            }
            mid = (p1+p2)/2;
            if(arr[p1]<arr[mid])
                p1 = mid;
            else if(arr[p2] > arr[mid])
                p2 = mid;
        }
        return arr[mid];
    }


}

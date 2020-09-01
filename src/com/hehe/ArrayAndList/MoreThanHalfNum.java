package com.hehe.ArrayAndList;

import java.util.Arrays;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 4, 2};
        System.out.println(MoreThanHalfNum((a)));


        System.out.println("=================");
        Arrays.sort(a);
        int mul = a[a.length / 2];
        System.out.println(mul);
    }


    /**
     * 数组中超过一半的数字
     *
     * @param a
     * @return
     */
    public static int MoreThanHalfNum(int[] a) {
        int res = a[0];  //数组中的数字
        int times = 1;  // 次数
        for (int i = 1; i < a.length; i++) {
            if (times == 0) {
                res = a[i];
                times = 1;
            } else if (a[i] == res)
                times++;
            else
                times--;
        }
        return res; //最后一次将 times 置为 1 的那个数，因为要找的那个数字比其他数字数量之和还要多
    }


    /**
     * 不存在返回 0
     *
     * 通过率 57%
     * @param a
     * @return
     */
    public static int MoreThanHalfNum01(int[] a) {
        int res = 0;
        if(a !=null && a.length > 0){
            Arrays.sort(a);
            int mid = a[a.length/2];
            int first = getFirstK(a,0,a.length/2,mid);
            int last = getLastK(a,a.length/2,a.length,mid);
            if((last - first + 1) > a.length/2){
                res = 2;
            }else
                res = 0;
        }

        return res;
    }

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



}

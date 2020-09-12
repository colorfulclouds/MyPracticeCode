package com.hehe.ArrayAndList;

import java.util.Arrays;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 4, 2};
        System.out.println(MoreThanHalfNum((a)));


        System.out.println("=======直接排序找超过一半的数字（中位数）==========");
        Arrays.sort(a);
        int mul = a[a.length / 2];
        System.out.println(mul);

        System.out.println("==============快排找超过一半的数字（中位数）=================");
        int res = QuickSort01(a, 0, a.length - 1);
        System.out.println(res);
    }




    /**
     * 快排找超过一半的数字（中位数）
     * @param a
     * @param l
     * @param r
     */
    public static int QuickSort01(int[] a, int l, int r) {
        int mid = (a.length-1)>> 1; //q代表已排序的数字的下标 等于mid时 即找到中位数 结束排序操作
        int q = onePartition(a, l, r);
        while (q != mid) {
            if (q < mid)
                q = onePartition(a, q + 1, r);
            else
                q = onePartition(a, l, q - 1);

        }
        return a[mid];
    }

    /**
     * 一次划分
     * @param a
     * @param l
     * @param r
     * @return
     */
    public static int onePartition(int[] a, int l, int r) {
        int provit = a[l];
        while (l < r && a[r] >= provit)
            r--;
        if (l < r)
            a[l++] = a[r];
        while (l < r && a[l] < provit)
            l++;
        if (l < r)
            a[r--] = a[l];

        a[l] = provit;
        return l;
    }

    /**
     * 数组中超过一半的数字（计数法）
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

    //========================================数组如果不存在最多的数字超过数组的一半 需要返回其它结果 代码如下=========================
    //先排序，再截取中位数那个位置上的数字的长度，看是否超过 len/2
    /**
     * 不存在返回 0
     * <p>
     * 通过率 57%(改了&&操作的条件 通过率未知)
     *
     * @param a
     * @return
     */
    public static int MoreThanHalfNum01(int[] a) {
        int res = 0;
        if (a != null && a.length > 0) {
            Arrays.sort(a);
            int mid = a[a.length / 2];
            int first = getFirstK(a, 0, a.length / 2, mid);
            int last = getLastK(a, a.length / 2, a.length, mid);
            if ((last - first + 1) > a.length / 2) {
                res = 2;
            } else
                res = 0;
        }

        return res;
    }

    public static int getFirstK(int[] nums, int start, int end, int k) {
        if (start > end)
            return -1;

        int mid = (start + end) >> 1;

        if (nums[mid] == k) {
            if ((mid > 0 && nums[mid - 1] != k) || mid == 0)
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
            if ((mid < nums.length && nums[mid + 1] != k) || mid == nums.length)
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

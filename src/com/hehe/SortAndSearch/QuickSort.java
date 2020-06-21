package com.hehe.SortAndSearch;

public class QuickSort {
    /**
     * 一次划分
     *
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
     * 快排01
     *
     * @param a
     * @param l
     * @param r
     */
    public static void QuickSort01(int[] a, int l, int r) {
        if (l < r) {
            int q = onePartition(a, l, r);
            System.out.println("本次选取的中轴值是：" + q);
            QuickSort01(a, l, q - 1);
            QuickSort01(a, q + 1, r);
        }
    }


    // =============================快排应用 1==================================

    /**
     * 1、利用一次划分求数组的中位数
     * <p>
     * 2、求数组中出现次数超过一半的数字 : O(n)
     * 【另法：根据数组特点找出时间复杂度为 O(n) 的算法 ：com.hehe.ArrayAndList.MoreThanHalfNum
     *   用堆适合海量数据的处理 O(nlogk)
     * 】
     * （排序后位于数组中间的数字一定就是那个出现次数超过数组长度一半的数字，即统计学上的中位数）
     * 但本算法不排除出现次数最多的那个数字不能够达到超过数组长度的一半的标准
     *
     * @param a
     * @return
     */
    public static int findMediaMethod2(int[] a) {

        //判断数组是否有效  --鲁棒
        if (a == null && a.length < 0)
            return 0;

        if (a.length == 0) return -1;
        //中位数位置
        int mid = (a.length - 1) / 2;
        //左右指针位置
        int left = 0, right = a.length - 1;
        //进行快排操作后哨兵元素的位置
        int provit = 0;
        provit = onePartition(a, left, right);
        while (true) {
            //System.out.println("qsIdx= "+qsIdx);
            if (provit == mid)
                break;
            else if (provit < mid)
                provit = onePartition(a, provit + 1, right);
            else
                provit = onePartition(a, left, provit - 1);
        }

        //检查result元素是否超过了数组的一半 --鲁棒
        int result = a[provit];
        if (!CheckIsvalid(a, a.length, result))
            return 0;

        return a[provit];
    }

    /**
     * 检查result元素是否超过了数组的一半
     *
     * @param a
     * @param length
     * @param result
     * @return
     */
    private static boolean CheckIsvalid(int[] a, int length, int result) {
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] == result)
                times++;
        }
        boolean isValid = true;
        if (times * 2 <= length)
            isValid = false;
        return isValid;
    }
    // =============================快排应用 2==================================

    /**最小的 k 个数
     * 寻找 k-1 位置的数字，其左边均为前 k 个小的数字
     *
     * @param input
     * @param k
     */
    public static void GetLeastKNumbers(int[] input, int k) {
        int len = input.length;
        int start = 0;
        int end = len - 1;
        int index = onePartition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = onePartition(input, start, end);
            } else {
                start = index + 1;
                index = onePartition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(input[i] + " ");
        }

    }

    // ==================================================================================

    private static void QuickSort02(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (l < r) {
            // 随机快排了！
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] a = Partition(arr, l, r);
            QuickSort02(arr, l, a[0] - 1);
            QuickSort02(arr, a[1] + 1, r);

        }
    }

    private static int[] Partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        // l和more 终会相遇
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        // 最后处理最右端被划在more里面的那个边界数
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    // ==================================================================================

    private static void swap(int[] a, int i, int r) {

    }

    public static void main(String[] args) {
        int[] a = {8, 6, 4, 1, 3, 2, 9};

        GetLeastKNumbers(a, 2);
        System.out.println();
//        QuickSort01(a, 0, a.length - 1);
//        System.out.println(findMediaMethod2(a));;

//        QuickSort02(a, 0, a.length - 1);


        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        // System.out.println();
        //
        // int[] b = {2,4,6,7,1,0};
        // quicksort(b, 0, b.length-1);
        //
        // for (int i = 0 ; i < b.length; i++) {
        // System.out.print(b[i]+" ");
        // }

    }

}

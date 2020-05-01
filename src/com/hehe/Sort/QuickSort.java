package com.hehe.Sort;

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
            System.out.println(q);
            QuickSort01(a, l, q - 1);
            QuickSort01(a, q + 1, r);
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
        return new int[] { less + 1, more };
    }

    // ==================================================================================

    private static void swap(int[] a, int i, int r) {

    }

    public static void main(String[] args) {
        int[] a = { 8, 6, 4, 1, 3, 2, 9 };

        QuickSort01(a, 0, a.length - 1);

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

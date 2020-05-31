package com.hehe.SortAndSearch;

/**
 * 插值算法 二分查找的一种提升算法
 * 求出mid 自适应  快速定位查找的值所在的较小的区间
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 9, 8};
        int index = InsertSearch(arr, 0, 0, arr.length - 1);
        System.out.println(index);

    }

    public static int InsertSearch(int a[], int key, int left, int right) {
        if (left > right || key > a[right] || key < a[left])
            return -1;

        //求出mid 自适应
        int mid = left + (key - a[left]) / (a[right] - a[left]) * (left - right);
        if (a[mid] > key)
            return InsertSearch(a, key, left, mid - 1);
        else if (a[mid] < key)
            return InsertSearch(a, key, mid + 1, right);
        else
            return mid;
    }


}

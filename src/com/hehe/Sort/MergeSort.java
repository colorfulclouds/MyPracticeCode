package com.hehe.Sort;

public class MergeSort {

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right || arr.length<2 || arr == null)
            return;

        int center = (left + right) / 2;
        //同等功效  且 防止溢出
//		int center = left +(right-left>>1);

        mergeSort(arr, left, center);
        mergeSort(arr, center + 1, right);
        merge(arr, left, center, right);
    }


    /**
     * 归并排序的 merge 操作
     * @param data
     * @param left
     * @param center
     * @param right
     */
    public static void merge(int[] data, int left, int center, int right) {
        // 申请临时数组
        int[] help = new int[data.length];
        int i = 0;
        // 左数组第一个元素索引
        int p1 = left;
        // 右数组第一个元素索引
        int p2 = center + 1;

        int res=0;
        if (p1 < center && p2 < right) {
            help[i++] = data[p1] < data[p2] ? data[p1] : data[p2];
            //改编代码，可用于求小和问题
            res += data[p1] < data[p2] ? (right - p2 + 1) : 0;
        }
        if (p1 < center) {
            help[i++] = data[p1];
        }
        if (p2 < right) {
            help[i++] = data[p2];
        }

        // 最后，将临时数组中的内容拷贝回原数组中
        //功能性函数  不需要返回值
        while (left < right) {
            data[left] = help[left];
        }
    }


    /**
     * 归并思想在小和问题上的应用 : 原mergeSort
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int mergeSortInSmallSort(int[] data, int left, int right) {
        if (left == right || data.length<2 || data == null)
            return -1;

        int center = (left + right) / 2;
        //同等功效
//		int center = left +(right-left>>1);

        return mergeSortInSmallSort(data, left, center)
                +mergeSortInSmallSort(data, center + 1, right)
                +mergeInSmallSum(data, left, center, right);
    }

    /**
     *  归并思想在小和问题上的应用 ： 原 merge
     * @param data
     * @param left
     * @param center
     * @param right
     * @return
     */
    public static int mergeInSmallSum(int[] data, int left, int center, int right) {
        // 申请临时数组
        int[] help = new int[data.length];
        int i = 0;
        // 左数组第一个元素索引
        int p1 = left;
        // 右数组第一个元素索引
        int p2 = center + 1;

        int res=0;
        if (p1 < center && p2 < right) {
            //原：help[i++] = data[p1] < data[p2] ? data[p1] : data[p2];
            //改编代码，可用于求小和问题
            res += data[p1] < data[p2] ? (right - p2 + 1) : 0;
        }
        if (p1 < center) {
            help[i++] = data[p1];
        }
        if (p2 < right) {
            help[i++] = data[p2];
        }

        // 最后，将临时数组中的内容拷贝回原数组中
        while (left < right) {
            data[left] = help[left];
        }
        return res;
    }
}

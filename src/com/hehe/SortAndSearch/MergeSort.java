package com.hehe.SortAndSearch;

public class MergeSort {

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right || arr.length < 2 || arr == null)  //一个元素 或者 空 的时候不用归并
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
     * @param arr
     * @param left
     * @param center
     * @param right
     */
    public static void merge(int[] arr, int left, int center, int right) {
        // 申请临时数组
//        int[] help = new int[arr.length]; 错误：arr大小是恒定不变的
        int[] help = new int[right - left + 1]; //help大小是 待排序的数组元素个数
        int i = 0;
        // 左数组第一个元素索引
        int p1 = left;
        // 右数组第一个元素索引
        int p2 = center + 1;
//        int res=0;
        while (p1 <= center && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            //改编代码，可用于求小和问题
//            res += data[p1] < data[p2] ? (right - p2 + 1) : 0;
        }
        while (p1 <= center) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        // 最后，将临时数组中的内容拷贝回原数组中
        //功能性函数 不需要返回值
//        while (left <= right) {
//            arr[left++] = help[left++];
//        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    /**
     * 小和问题描述
     * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
     *
     * 例子
     * [1,3,4,2,5]
     * 1左边比1小的数：没有
     * 3左边比3小的数：1
     * 4左边比4小的数：1,3
     * 2左边比2小的数：1
     * 5左边比5小的数：1,3,4,2
     * 所以小和为1+1+3+1+1+3+4+2=16
     * ————————————————
     * 版权声明：本文为CSDN博主「数学家是我理想」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_37236745/article/details/83625679
     */
    /**
     * 归并思想在小和问题上的应用 : 原mergeSort
     * 本部分代码仍然有错 正确见（SortCodePra）
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int mergeSortInSmallSort(int[] data, int left, int right) {
        if (left == right || data.length<2 || data == null)
            return -1;  // X

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
        int[] help = new int[data.length];  // X
        int i = 0;
        // 左数组第一个元素索引
        int p1 = left;
        // 右数组第一个元素索引
        int p2 = center + 1;

        int res=0;
        while (p1 <= center && p2 <= right) {
            //原：help[i++] = data[p1] < data[p2] ? data[p1] : data[p2];
            //改编代码，可用于求小和问题
            res += data[p1] < data[p2] ? (right - (p2) + 1) : 0;   // X
        }
        while (p1 <= center) {
            help[i++] = data[p1++];
        }
        while (p2 <= right) {
            help[i++] = data[p2++];
        }

        // 最后，将临时数组中的内容拷贝回原数组中
        for (i = 0; i < help.length; i++) {
            data[left + i] = help[i];
        }
        return res;
    }



}

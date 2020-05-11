package com.hehe.SortAndSearch;

import java.util.Arrays;

/*插入排序
 * 79   47   47   17   39   96   76   53   57   98
 * 17   39   47   47   53   57   76   79   96   98
 *
 * */

//!!  j >= 0
public class InsertSort {

    public static void InsertSort01(int[] arr) {
        // 插入排序
        int cur, p;  //cur 当前待排序
        for (int i = 1; i < arr.length; i++) {  //趟数 ： n-1趟
            for (cur = arr[i], p = i - 1; p >= 0 && arr[p] > cur; p--) //每趟往待排区域遍历插入一个数
                arr[p + 1] = arr[p]; //移动
            arr[p + 1] = cur;
        }
    }


    public static void InsertSort02(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }


    // 交换方法
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        // arr[i] = arr[i] ^arr[j];
        // arr[j] = arr[i] ^arr[j];
        // arr[i] = arr[i] ^arr[j];
    }

    /**
     * 产生一个大小和数值都随机的随机数组
     *
     * @param size  最大容量
     * @param value 最大值
     * @return
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * (value + 1) - (int) (Math.random() * (value + 1))));
        }
        return arr;
    }

    /**
     * 拷贝出一个一样的数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;

    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {

        if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 绝对正确的方法
     *
     * @param arr
     */
    public static void Right(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        /**
         * 随机数生成
         */
        // int[] sort = new int[10];
        // for (int i = 0; i < sort.length; i++) {
        // // 产生1-100之间的随机数
        // sort[i] = (int) (Math.random() * 100);
        // }
        // for (int i = 0; i < sort.length; i++) {
        // System.out.print(sort[i] + " ");
        // }
        // System.out.println();

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            InsertSort02(arr1);
            Right(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("排列前的顺序为：");
        printArray(arr);

//        InsertSort01(arr);
        InsertSort02(arr);

        System.out.println("排列后的顺序为：");
        printArray(arr);
    }

}


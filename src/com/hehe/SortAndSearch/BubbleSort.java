package com.hehe.SortAndSearch;
/*冒泡排序：
 * 请输入10个排序的数据：
 * 1 3 2 5 6 4 7 8 9 0
 * 排列后的顺序为：
 * 9   8   7   6   5   4   3   2   1   0
 *
 *
 *
 * 3 4 5 6 7 8 9 2 0 1
 * */

public class BubbleSort {

    public static void main(String[] args) {
        // 随机数生成
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            // 产生1-100之间的随机数
            arr[i] = (int) (Math.random() * 100);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
        System.out.println("============================================== ");
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        bubbleSort(arr);
        bubbleSort01(arr);
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // 排列后的顺序
        SysOut(arr);
    }

    //1.
    public static void bubbleSort(int[] arr) {
        int temp;

        // 排序
        for (int i = 0; i < arr.length - 1; i++) { // 趟数 n-1趟
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    //2.
    public static void bubbleSort01(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        for (int end = arr.length - 1; end > 0; end--) { //控制趟数
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //工具方法：交换方法
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void SysOut(int[] arr) {
        System.out.println("排列后的顺序为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }
}

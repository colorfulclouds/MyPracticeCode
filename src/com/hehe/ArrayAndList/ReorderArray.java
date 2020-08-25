package com.hehe.ArrayAndList;

import java.util.Arrays;

/**
 * 重排数组 奇前偶后
 *
 */
public class ReorderArray {
    /**
     * 辅助数组返回 不改变相对顺序
     * @param array
     * @return
     */
    public static int[] reOrderArray(int[] array) {
        if (array.length == 0 || array == null)
            return new int[]{};
        int[] newArray = new int[array.length];
        int len = array.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 == 1){
                newArray[k++] = array[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 == 0){
                newArray[k++] = array[i];
            }
        }
        return newArray;
    }

    /**
     * 原数组返回 不改变相对顺序
     * @param array
     */
    public static void reOrderArray01(int[] array) {
        if (array.length == 0 || array == null)
            return;
        int[] newArray = new int[array.length];
        int len = array.length;

        int k = 0;
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 == 1){
                newArray[k++] = array[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 == 0){
                newArray[k++] = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            array[i] = newArray[i];
        }
    }


    /**
     * 改变相对顺序
     * @param arr
     */
    static void reOrderArray03(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }

        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && (arr[p1] & 0x1) == 1)  //该部分的条件可提取出一个函数 作为函数参数传递使用 达到解耦效果
                p1++;
            while(p1 < p2 && (arr[p2] & 0x1) == 0)
                p2--;
            if(p1 < p2){
                int tmp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = tmp;
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] newArr = reOrderArray(arr);
        for(int i : newArr){
            System.out.print(i + " ");
        }

        int[] arr1 = {1,7,4,3,2,5,3};
        reOrderArray03(arr1);
        for(int a : arr1){
            System.out.print(a + " ");
        }

    }


    /**
     * 另一种思想
     */

    /**
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     */
}

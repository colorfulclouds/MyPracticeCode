package com.hehe.ArrayAndList;

import java.util.Arrays;

/**
 * 重排数组 奇前偶后
 */
public class ReorderArray {
    /**
     * 辅助数组返回
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
     * 原数组返回
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] newArr = reOrderArray(arr);
        for(int i : newArr){
            System.out.print(i + " ");
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

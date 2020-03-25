package com.hehe.Sort;

public class SelectSort {
    /*
     * 43 83 67 82 51 97 52 24 74 78 排列后的顺序为: 24 43 51 52 67 74 78 82 83 97
     *
     */

    public static void SelectSort01(int[] sort) {
        int pos, j, tem;
        for (int i = 0; i < sort.length; i++) {
            for (pos = i, j = i + 1; j < sort.length; j++) {
                if (sort[j] < sort[pos]) {
                    pos = j;
                }
            }
            tem = sort[i];
            sort[i] = sort[pos];
            sort[pos] = tem;
        }

    }

    public static void SelectSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minindex = arr[j] < arr[minindex] ? j : minindex;
            }
            swap(arr, i, minindex);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    public static void main(String[] args) {
        // 1随机数生成
        int sort[] = new int[10];
        for (int i = 0; i < sort.length; i++) {
            // 产生1-100之间的随机数
            sort[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + "   ");
        }
        System.out.println();

        // 2.
//		SelectSort01(sort);

        SelectSort02(sort);


        // 输出
        System.out.println("排列后的顺序为：");
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + "   ");
        }

    }

}

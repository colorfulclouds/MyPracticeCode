package com.hehe.ArrayAndList;

public class ReorderOddEven {
    public static void main(String[] args) {
        int[] arr = {1,7,4,3,2,5,3};
        reorderArray(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }


    static void reorderArray(int[] arr) {
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
}

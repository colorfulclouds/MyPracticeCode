package com.hehe.Sort;

public class HeapSort {

    /**
     * 堆顶的小元素往下沉
     *
     * @param arr
     * @param i
     * @param heapsize
     */
    private static void heapify(int[] arr, int index, int heapsize) {
        int left = index * 2 + 1;
        while (left < heapsize) {
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     *
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆排
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length <2){
            return;
        }
        //建堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        //弹性堆的大小
        int heapsize = arr.length;
        //开始排序，堆顶（数组0位置上的数）就是最大值，放置数组的最后
        swap(arr,0,--heapsize);
        while(heapsize > 0){
            heapify(arr,0,heapsize); //调出一个大根堆
            swap(arr,0,--heapsize);  //继续将最大的放置数组的最后
        }
    }


    /**
     * 交换数组两个数
     * @param arr 数组
     * @param i 下标
     * @param j 下标
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }


    public static void main(String[] args) {
        int[] arr = {7,9,1,2,4,6,8};
        System.out.println(arr.length);
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}

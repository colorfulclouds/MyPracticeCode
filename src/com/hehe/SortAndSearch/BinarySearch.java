package com.hehe.SortAndSearch;

public class BinarySearch {
    /**
     * 递归二分查找
     *
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key > arr[mid]) {
            return recursionBinarySearch(arr, key, mid + 1, high);
        } else if (key < arr[mid]) {
            return recursionBinarySearch(arr, key, low, mid - 1);
        } else {
            return mid;
        }
    }

    /**
     * 非递归二分查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1, mid = 0;
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            mid = (high + low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;


    }


    //    int low = 0;
//    int high = arr.length - 1;
//    int middle = 0;            //定义middle
//
//        if (key < arr[low] || key > arr[high] || low > high) {
//        return -1;
//    }
//        while (low <= high) {
//        middle = (low + high) / 2;
//        if (arr[middle] > key) {
//            //比关键字大则关键字在左区域
//            high = middle - 1;
//        } else if (arr[middle] < key) {
//            //比关键字小则关键字在右区域
//            low = middle + 1;
//        } else {
//            return middle;
//        }
//    }
//        return -1;
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 3;
        System.out.println(recursionBinarySearch(arr, key, 0, arr.length - 1));
        System.out.println(commonBinarySearch(arr,key));


//        int position = commonBinarySearch(arr, key);
//
//        if (position == -1) {
//            System.out.println("查找的是" + key + ",序列中没有该数！");
//        } else {
//            System.out.println("查找的是" + key + ",找到位置为：" + position);
//        }
    }

}

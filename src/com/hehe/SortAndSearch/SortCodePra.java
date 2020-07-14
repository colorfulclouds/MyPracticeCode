package com.hehe.SortAndSearch;

public class SortCodePra {
    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 100;

//        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arr = {1, 3, 4, 2, 5, 7, 8, 9};
        System.out.println("排列前的顺序为：");
        printArray(arr);

        Insertsort(arr);
//        BubbleSort(arr);
//        QuikSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);
//        int n = mergeSortInSmallSort(arr, 0, arr.length - 1);
//        System.out.println("该数组的小和为： " + n);
//
        System.out.println("排列后的顺序为：");
        printArray(arr);
//        System.out.println(Math.floor(9/2));
//        System.out.println(findMediaMethod2(arr));
        System.out.println("=====================================================");
        int[] arr1 = {7,5,6,4};
        int[] arr2 = {1,2,3,4};
        System.out.println(mergeSortInINversion(arr1,0,arr1.length-1));;
        System.out.println(mergeSortInINversion(arr2,0,arr1.length-1));;

    }

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

    /**
     * 小和问题 求解
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int mergeSortInSmallSort(int[] data, int left, int right) {
        if (left == right || data.length < 2 || data == null)  // **小和问题返回需要更改为0 递归过程中 该值会作为小和结果 res 的一部分加入进来
            return 0;

        int center = (left + right) / 2;
        //同等功效
//		int center = left +(right-left>>1);

        return mergeSortInSmallSort(data, left, center) //左侧部分
                + mergeSortInSmallSort(data, center + 1, right) //右侧部分
                + mergeInSmallSum(data, left, center, right);  //merge 过程中计算的小和值
    }

    public static int mergeInSmallSum(int[] data, int left, int center, int right) {
        // 申请临时数组
        int[] help = new int[right - left + 1];
        int i = 0;
        // 左数组第一个元素索引
        int p1 = left;
        // 右数组第一个元素索引
        int p2 = center + 1;

        int res = 0;
        int count = 0;
        while (p1 <= center && p2 <= right) {
            //原：help[i++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
            //改编代码，可用于求小和问题
//            res += data[p1] < data[p2] ? (right - p2 + 1) : 0;  //错误的
            res += data[p1] < data[p2] ? (right - p2 + 1) * data[p1] : 0;
            // ** (right - p2 + 1)含义是 【1 3 4】 【2 5】当下标 l==1，r==3时,1同时是元素2和5的小和


            //改编代码，用于求逆序对  【1 4】 【2 3】
            count += data[p1] < data[p2] ? (right - p2 + 1) : 0;

            help[i++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
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
//        return res;
        return count;
    }

    public static int mergeSortInINversion(int[] data, int left, int right) {
        if (left == right || data.length < 2 || data == null)  // **小和问题返回需要更改为0 递归过程中 该值会作为小和结果 res 的一部分加入进来
            return 0;

        int center = (left + right) / 2;
        //同等功效
//		int center = left +(right-left>>1);

        return mergeSortInINversion(data, left, center) //左侧部分
                + mergeSortInINversion(data, center + 1, right) //右侧部分
                + mergeInInversion(data, left, center, right);  //merge 过程中计算的小和值
    }
    public static int mergeInInversion(int[] data, int left, int center, int right) {
        // 申请临时数组
        int[] help = new int[right - left + 1];
        int i = help.length-1;
        // 左数组第一个元素索引
        int p1 = center;
        // 右数组第一个元素索引
        int p2 = right;

        int count = 0;
        while (p1 >= left && p2 >= center+1) {
            //原：help[i++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
            //改编代码，可用于求小和问题
            // ** (right - p2 + 1)含义是 【1 3 4】 【2 5】当下标 l==1，r==3时,1同时是元素2和5的小和
//            res += data[p1] < data[p2] ? (right - p2 + 1) * data[p1] : 0;

            //改编代码，用于求逆序对  【1 4】 【2 3】
            count += data[p1] > data[p2] ? (right - p2+1) : 0;

            help[i--] = data[p1] < data[p2] ? data[p2--] : data[p1--];
        }
        while (p1 >= left) {
            help[i--] = data[p1--];
        }
        while (p2 >= center+1) {
            help[i--] = data[p2--];
        }

        // 最后，将临时数组中的内容拷贝回原数组中
        for (i = 0; i < help.length; i++) {
            data[left + i] = help[i];
        }
        return count;
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right || arr.length < 2 || arr == null) {
            return;
        }
        int center = (left + right) / 2;
        mergeSort(arr, left, center);
        mergeSort(arr, center + 1, right);
        merge(arr, left, center, right);
    }

    public static void merge(int[] arr, int left, int center, int right) {

        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = center + 1;
        int i = 0;
        while (p1 <= center && p2 <= right)
            help[i++] = p1 < p2 ? arr[p1++] : arr[p2++];
        while (p1 <= center)
            help[i++] = arr[p1];
        while (p2 <= right)
            help[i++] = arr[p2];

        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j++];
        }

    }


    public static void Insertsort(int[] arr) {
        int cur, p;
        for (int i = 1; i < arr.length; i++) {
            for (cur = arr[i], p = i - 1; p >= 0 && cur < arr[p]; p--) {
                arr[p + 1] = arr[p];
            }
            arr[p + 1] = cur;
        }
    }

    public static void BubbleSort(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void QuikSort(int[] arr, int l, int r) { //递归方法 注意参数
        if (l < r) {
            int p = onePartition(arr, l, r);
            QuikSort(arr, l, p - 1);
            QuikSort(arr, p + 1, r);
        }

    }

    private static int onePartition(int[] arr, int l, int r) {
        int provit = arr[l];
        while (l < r && arr[r] >= provit)
            r--;
        if (l < r)
            arr[l++] = arr[r];
        while (l < r && arr[l] <= provit)
            l++;
        if (l < r)
            arr[r++] = arr[l];
        arr[l] = provit;
        return l;
    }


    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * (value + 1) - (int) (Math.random() * (value + 1))));
        }
        return arr;
    }


    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}

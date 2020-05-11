package com.hehe.SortAndSearch;

public class SortCodePra {
    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 100;

        int[] arr = generateRandomArray(maxSize, maxValue);
//        int[] arr = {1,3,4,2,5};
        System.out.println("排列前的顺序为：");
        printArray(arr);

//        Insertsort(arr);
//        BubbleSort(arr);
        QuikSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);
        int n = mergeSortInSmallSort(arr,0,arr.length-1);
        System.out.println("该数组的小和为： "+ n);


        System.out.println("排列后的顺序为：");
        printArray(arr);
    }

    /**
     * 小和问题 求解
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int mergeSortInSmallSort(int[] data, int left, int right) {
        if (left == right || data.length<2 || data == null)  // **小和问题需要更改为0 递归过程中 该值会作为小和结果 res 的一部分加入进来
            return 0;

        int center = (left + right) / 2;
        //同等功效
//		int center = left +(right-left>>1);

        return mergeSortInSmallSort(data, left, center) //左侧部分
                +mergeSortInSmallSort(data, center + 1, right) //右侧部分
                +mergeInSmallSum(data, left, center, right);  //merge 过程中计算的小和值
    }

    public static int mergeInSmallSum(int[] data, int left, int center, int right) {
        // 申请临时数组
        int[] help = new int[right-left+1];
        int i = 0;
        // 左数组第一个元素索引
        int p1 = left;
        // 右数组第一个元素索引
        int p2 = center + 1;

        int res=0;
        while (p1 <= center && p2 <= right) {
            //原：help[i++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
            //改编代码，可用于求小和问题
//            res += data[p1] < data[p2] ? (right - p2 + 1) : 0;  //错误的
            res += data[p1] < data[p2] ? (right - p2 + 1) * data[p1] : 0;  // ** (right - p2 + 1)含义是 【1 3 4】 【2 5】当下标 l==1，r==3时,1同时是元素2和5的小和
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
        return res;
    }

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
        int[] help = new int[right-left + 1];
        int i = 0;
        int p1 = left;
        int p2 = center + 1;
        while (p1 <= center && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= center)
            help[i++] = arr[p1++];

        while (p2 <= right)
            help[i++] = arr[p2++];

        for (i= 0; i< help.length; i++) {
            arr[left + i] = help[i];
        }


    }


    public static void Insertsort(int[] arr) {
        int cur, p;
        for (int i = 1; i < arr.length; i++) {
            for (cur = arr[i], p = i - 1; p >= 0 && arr[p] > cur; p--)
                arr[p + 1] = arr[p];
            arr[p + 1] = cur;
        }
    }

    public static void BubbleSort(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
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

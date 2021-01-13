package com.tmp;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1};
        int[] arr1 = {0, 1, 3, 5};
        System.out.println(Find(arr));
        System.out.println(Find(arr1));
    }

    public static int Find(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            while (i + 1 < arr.length && arr[i] < arr[i + 1])
                i++;
            if (i == arr.length - 1)
                return -1;
            else {
                j += 2;
                if (j < arr.length - 1 && arr[j] > arr[i]) {
                    while (arr[j] < arr[j + 1] && j < arr.length - 1)
                        j++;
                    if (j == arr.length - 1) {
                        return i + 1;
                    } else
                        return -1;
                } else {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}

package com.hehe.Classic;

public class minNumberInRotateArray {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        int[] array1 = {1, 1, 1, 0, 1, 1};
        int[] array2 = {1, 2, 3, 4, 5};

        System.out.println(minNumberInRotateArray(array));
        System.out.println(minNumberInRotateArray(array1));
        System.out.println(minNumberInRotateArray(array2));

    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length <= 0 && array == null)
            return 0;

        int a = 0, b = array.length - 1;
        int mid = a;
        while (array[a] >= array[b]) {
            if (b - a == 1) {
                mid = b;
                break;
            }
            mid = (a + b) / 2;
            if (array[a] == array[b] && array[mid] == array[b])
                return minInArray(array, a, b);

            if (array[mid] >= array[a])
                a = mid;
            else if (array[mid] <= array[b])
                b = mid;


        }
        return array[mid];
    }

    private static int minInArray(int[] array, int a, int b) {
        int res = array[a];
        for (int i = a + 1; i <= b; i++) {
            if (array[i] < res)
                res = array[i];
        }
        return res;
    }
}

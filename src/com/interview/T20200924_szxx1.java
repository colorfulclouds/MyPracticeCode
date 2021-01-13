package com.interview;

public class T20200924_szxx1 {
    public static void main(String[] args) {
        System.out.println(sort("19 5 9 255"));
    }
    public static int sort (String inData) {
        String[] s_str = inData.split(" ");
        int[] arr = new int[s_str.length];
        for (int i = 0; i < s_str.length; i++) {
            arr[i] = Integer.valueOf(s_str[i]);
        }

        int temp = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        return count;
    }


}

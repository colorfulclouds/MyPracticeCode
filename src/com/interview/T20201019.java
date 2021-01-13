package com.interview;

import java.util.Arrays;

public class T20201019 {
    public static void main(String[] args) {

    }

    public int sub (String input) {
        String[] str = input.split(" ");
        int i = 0;
        int len = str.length;
        int[] arr = new int[len];
        if(i<len){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int max = arr[len-1]*100 + arr[len-2]*10 +arr[len-3];
        int min = 0;
        if(arr[0] != 0)
            min = arr[0]*100+arr[1]*10+arr[2];
        else
            min = arr[1]*100+arr[2];
        return max-min;
    }
}

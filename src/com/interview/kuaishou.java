package com.interview;

import java.util.HashSet;

public class kuaishou {
    public static void main(String[] args) {
//        int[] arr = {3,1,4,5,6,8};
//        int len = arr.length;
//        Sort(arr,0,len-1);
//        for(int i = 0;i< len;i++){
//            System.out.print(arr[i] + " ");
//        }

        String a = "adc";
        String b = "hgdchaf";
        System.out.println(Sub(a, b));
//        System.out.println(b.substring(2,4));
    }

    public static String Sub(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            set.add(a.charAt(i));
        }
        int start = 0;
        int end = 0;
        int c = set.size();
        for (int j = 0; j < len2; j++) {
            if (set.contains(b.charAt(j))) {
                if (c == len1) {
                    start = j;
                    c--;
                } else if (c >1)
                    c--;
                else if (c == 1){
                    end = j;
                    break;
                }
            }
        }
        if(end == len2 - 1)
            return b.substring(start);
        else
            return b.substring(start,end+1);

    }





    public static void Sort(int[] arr, int l, int r) {
        if (l < r) {
            int p = onePartition(arr, l, r);
            Sort(arr, l, p - 1);
            Sort(arr, p + 1, r);
        }
    }

    public static int onePartition(int[] arr, int l, int r) {
        int pro = arr[l];
        while (l < r && arr[r] > pro)
            r--;
        if (l < r)
            arr[l++] = arr[r];
        while (l < r && arr[l] < pro)
            l++;
        if (l < r)
            arr[r--] = arr[l];
        arr[l] = pro;
        return l;
    }

}

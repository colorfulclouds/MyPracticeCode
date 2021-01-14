package com.hehe.RecursiveAndDynamic;

//题目逻辑：
//int a = rec_opt(arr, i-2) + arr[i];
//int b = rec_opt(arr, i-1);
//return Math.max(a, b);

public class _numMax {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 2, 4, 1, 7, 8,3};
//        List<Integer> aa = new ArrayList<Integer>();
        System.out.println(dp_opt(arr));
        System.out.println(rec_opt(arr,3));
    }

    /**
     * 递归解法
     * @param arr
     * @param i
     * @return
     */
    public static int rec_opt(int[] arr, int i) {
        if(i == 0)
            return arr[0];
        else if (i == 1)
            return Math.max(arr[0], arr[1]);
        else {
            int a = rec_opt(arr, i-2) + arr[i];
            int b = rec_opt(arr, i-1);
            return Math.max(a, b);
        }
    }

    /**
     * 动态规划解法
     * @param arr
     * @return
     */
    public static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++) {
            int a = opt[i-2] + arr[i];
            int b = opt[i-1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length-1];
    }

}






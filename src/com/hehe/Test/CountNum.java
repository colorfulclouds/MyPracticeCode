package com.hehe.Test;

public class CountNum {

    //统计0-9各个数字的个数
    public static int[] count(int[] nums){
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        return arr;

    }
    public static void main(String[] args) {
        //测试count
		int[] arr = {1,3,3,5,6,1,6,9,0,0};
		int[] result = count(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(i + " 有" + result[i]+" 个");
		}


    }

}


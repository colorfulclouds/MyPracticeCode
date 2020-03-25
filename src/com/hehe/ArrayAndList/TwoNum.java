package com.hehe.ArrayAndList;

import java.util.HashMap;
import java.util.Map;

/*
 * 两数之和等于既定的目标数字，找出这两个数，返回在数组的中的下标
 * */
public class TwoNum {

    public static void main(String[] args) {
        int[] nums = {3, 9, 8, 1};
        int target = 9;
        int[] rst = twoSum(nums, target);
//		for(int i:rst){
//			System.out.print(i);
//		}
        System.out.print("[" + rst[0] + "," + rst[1] + "]");
    }

    //两数之和等于target，并输出两数下标（数组类型）
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //依次加入map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        //对每一个数字遍历寻找其另一半
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            //若存在一个值等于另一半，而且不是当前i的角标
            if (map.containsKey(complement) && map.get(complement) != i) {
                //返回两个数字下标的数组形式
                return new int[]{i, map.get(complement)};
            }
        }
//		    throw new IllegalArgumentException("No two sum solution");
        return null;
    }
}


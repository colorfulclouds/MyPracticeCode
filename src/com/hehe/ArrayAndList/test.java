package com.hehe.ArrayAndList;

import javafx.print.Collation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String s = "2dsdfd";
        int i = 0;
        while(i<s.length()){    //java中String 没有结束标识 '\0',故不能用s.charAt(i)!='\0' 来判断串的结束
            System.out.println(s.charAt(i));
            i++;
        }


        //Arrays.toString  Arrays.deepToString
//        int a[] = {1, 2, 3};
//        System.out.println(Arrays.toString(a));
//        int b[][] = {{1, 2, 3}, {4, 5, 6}};
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.deepToString(b));


//        int nums[] = {-4, -2, 1, 0, 0, -2, 3, 1, -5, 0};
//        List<List<Integer>> ends = threeSum(nums);
//        for (List<Integer> i : ends) {
//            System.out.println(i);
//        }
    }

//    private static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        int a, b;
//        for (int i = 0; i < nums.length - 2; ) {
//            a = i + 1;
//            b = nums.length - 1;
//            while (a < b) {
//                if (nums[a] + nums[b] == -nums[i]) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[a]);
//                    list.add(nums[b]);
//                    list.add(nums[i]);
//                    res.add(list);
//
//                    a++;
//                    while (nums[a] == nums[a - 1] && a < b)
//                        a++;
//                    b--;
//                    while (nums[b] == nums[b + 1] && a < b)
//                        b--;
//                } else if (nums[a] + nums[b] > -nums[i]) {
//                    b--;
//                    while (nums[b] == nums[b + 1] && a < b)
//                        b--;
//                } else {
//                    a++;
//                    while (nums[a] == nums[a - 1] && a < b)
//                        a++;
//                }
//            }
//
//            i++;
//            while (nums[i] == nums[i - 1] && i < nums.length - 2)
//                i++;
//        }
//        return res;
//    }
}

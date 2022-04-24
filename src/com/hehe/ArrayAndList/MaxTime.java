package com.hehe.ArrayAndList;

import java.util.Scanner;
/*找出输入的字符串中能够组合表示的最大的时间
 *
 * */

/* 输入{9，9，9，9，9，9}
 * 输出 invalid
 *
 * 输入{0，2，3，4，5，6}
 * 输出23：56：40
 *
 * 注意输入格式
 * */
public class MaxTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        //输入的数组，接收时是字符串，需要处理

        strs[0] = strs[0].substring(1);
        strs[strs.length - 1] = strs[strs.length - 1].substring(0, 1);
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
            //System.out.println(nums[i]);
        }
        happy_2_day(nums);
    }

    public static void happy_2_day(int[] nums) {
        int[] _max = {23, 59, 59};
        int[] flag = {0, 0, 0, 0, 0, 0};
        String[] result = new String[3];
        int max = 0;

        //依次为result数组赋值
        for (int i = 0; i < result.length; i++) {
            max = Find(nums, flag, _max[i]);
            if (max == -1) {
                System.out.println("invalid");
//                System.exit(-1);
            } else if (max < 10) {
//                String tmp = "0" + String.valueOf(max);
                String tmp = "0" + max;
                result[i] = tmp;
            } else {
                result[i] = String.valueOf(max);
            }
        }
        System.out.println(result[0] + ":" + result[1] + ":" + result[2]);

    }

    public static int Find(int[] nums, int[] flag, int _max) {
        int max = -1;
        int max_i = 0;  //本次找到的使时间最大的数组下标
        int max_j = 0;

        //二重遍历数组中数字（时分秒各有两位数字）
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //循环没有被用过的数字
                if (flag[i] != -1 && flag[j] != -1) {
                    //1.   i*10+j
                    int max1 = nums[i] * 10 + nums[j];
                    if (max < max1 && max1 <= _max) {
                        max = max1;
                        max_i = i;
                        max_j = j;
                    }
                    //2.    j*10+i
                    int max2 = nums[j] * 10 + nums[i];
                    if (max < max2 && max2 <= _max) {
                        max = max2;
                        max_i = i;
                        max_j = j;
                    }
                }
            }
        }

        if (flag[max_i] != -1 && flag[max_j] != -1) {
            flag[max_i] = -1;
            flag[max_j] = -1;
        }
        return max;


    }


}


//{2,3,6,2,9,1}
//{2,3,9,2,9,2}

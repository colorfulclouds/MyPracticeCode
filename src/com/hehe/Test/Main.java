package com.hehe.Test;

import java.sql.SQLOutput;
import java.util.*;


/**数组中的最长连续子序列
 *
 * 输入
 * [100,4,200,1,3,2]
 * 输出
 * 4
 * 示例2
 * 输入
 * [1,1,1]
 * 输出
 * 1
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(Math.round(-1.5));
//        int[] arr = {100,4,200,1,3,2};
//        System.out.println(MLS(arr));
//
//        int[] arr1 = {1,1,1,1};
//        System.out.println(MLS(arr1));

        Test a = new Test();
        a.add().add().show();

    }

    public static class Test{
        static int i;
        Test add(){
            i++;
            return this;
        }

        private void show(){
            System.out.println(i);
        }
    }

    public static int MLS (int[] arr) {
        if(arr == null || arr.length < 1)
            return 0;
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : set){
            list.add(i);
        }
        int count = 1;
        int max = 1;
        for(int i = 0;i < list.size() - 1;i++){
            if(list.get(i+1) - list.get(i) == 1){
                count++;
                max = Math.max(max,count);
            }
            else
                count = 1;
        }

        return max;
        // write code here
    }


    public static int walk01(int[][] matrix) {
        return walkll(matrix,0,0);
    }

    private static int walkll(int[][] matrix, int i, int j) {
        if(i == matrix.length-1 && j == matrix[0].length-1)
            return matrix[i][j];
        if(i == matrix.length-1){
            return matrix[i][j] + walkll(matrix,i,j+1);
        }
        if(j == matrix[0].length-1){
            return matrix[i][j] + walkll(matrix,i+1,j);
        }

        int right = walkll(matrix,i,j+1);
        int down = walkll(matrix,i+1,j);
        return matrix[i][j] + Math.min(right,down);
    }


}

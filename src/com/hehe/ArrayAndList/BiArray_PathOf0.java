package com.hehe.ArrayAndList;

/**
 * 从（0，0）开始 判断二维数组中是否有全为0的路径 到最后一个位置
 */
public class BiArray_PathOf0 {
    public static void main(String[] args) {
        int[][] arr = {{0,1,0,0},{0,0,1,0},{1,1,1,0},{1,1,1,0}};
        System.out.println(HasPathOf0(arr));
    }

    public static boolean HasPathOf0(int[][] arr) {
        if(arr == null || arr.length < 1 || arr[0].length < 1)
            return false;
        int row = arr.length;
        int col = arr[0].length;

        return HasPathCore(arr, 0, 0, row, col);
    }

    private static boolean HasPathCore(int[][] arr, int i, int j, int row, int col) {
        if(arr[i][j] != 0 || i >= row || j >= col)
            return false;
        if (i == row - 1 && j == col - 1)
            return true;

        return HasPathCore(arr, i + 1, j, row, col) || HasPathCore(arr, i, j + 1, row, col);
    }


//    boolean res;
//    public boolean hasPath(int[][] matrix){
//        if (matrix == null || matrix.length < 1 || matrix[0].length<1)
//            return true;
//        dfs(matrix,0,0);//从左上角开始递归
//        return res;
//    }
//
//    private void dfs(int[][] matrix, int i, int j) {
//        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] != 0)
//            return;
//        if (i==matrix.length-1 && j == matrix[0].length-1){
//            res = true;
//            return;
//        }
//        dfs(matrix,i+1,j);
//        dfs(matrix,i,j+1);
//    }
}

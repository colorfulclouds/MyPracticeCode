package com.hehe.ArrayAndList;

public class BiArray_PathOfStr {

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        char[] str = {'b','c','c','e','d'};
        char[] str1 = {'a','b','c','d'};
//        boolean[][] used = new boolean[M][N];
        System.out.println(hasPath01(matrix,str));
        System.out.println(hasPath01(matrix,str1));
    }

    /**
     * 二维矩阵中是否存在该路径
     * @param matrix
     * @param str
     * @return
     */
    public static boolean hasPath01(char[][] matrix, char[] str) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(judgeto(matrix,i,j,row,col,str,0))
                    return true;
            }
        }
        return false;
    }

    private static boolean judgeto(char[][] matrix, int i, int j, int row, int col, char[] str, int k) {
        if (i < 0 || j < 0 || i >= row || j >= col || matrix[i][j] != str[k])
            return false;
        if(k == str.length - 1)
            return true;

        return judgeto(matrix,i-1,j,row,col,str,k + 1)
                ||judgeto(matrix,i+1,j,row,col,str,k + 1)
                ||judgeto(matrix,i,j+1,row,col,str,k + 1)
                ||judgeto(matrix,i,j-1,row,col,str,k + 1);
    }

    /**
     * 二维矩阵中是否存在该路径（二维矩阵用一维表示）
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1))
        {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }

}

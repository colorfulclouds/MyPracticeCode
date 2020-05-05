package com.hehe.RecursiveAndDynamic;

/**
 * 二维数组中 从左上到右下，每一步只能向下或者向右，沿途经过的数字累加和最小
 *
 * 递归版本
 * --》改编
 * 动态规划
 */
public class MinPath_zs {
    /**
     * 递归版本的最短路径
     * @param matrix
     * @return
     */
    public static int walk01(int[][] matrix) {
        return walk(matrix, 0, 0);
    }

    public static int walk(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            return matrix[i][j];
        if (i == matrix.length - 1)
            return matrix[i][j] + walk(matrix, i, j + 1);
        if (j == matrix[0].length - 1)
            return matrix[i][j] + walk(matrix, i + 1, j);

        int right = walk(matrix,i,j+1);
        int down = walk(matrix,i+1,j);
        return matrix[i][j] + Math.min(right, down);
    }


    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

    /**
     * 动态规划求解
     * dp : 辅助数组
     * @param m
     * @return
     */
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
//        System.out.println(walk01(m));
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}

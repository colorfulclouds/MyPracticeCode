package com.hehe.ArrayAndList;

public class PrintMatrixSomeWays {

    /**
     * 旋转打印矩阵01
     *
     * @param matrix
     */
    public static void spiralPrintMatrix(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (aR <= bR && aC <= bC) {
            printEdge(matrix, aR++, aC++, bR--, bC--);
        }
    }

    /**旋转打印矩阵02 打印一圈即可
     *
     * @param matrix
     * @param aR
     * @param aC
     * @param bR
     * @param bC
     */
    private static void printEdge(int[][] matrix, int aR, int aC, int bR, int bC) {
        if (aR == bR) {
            for (int i = 0; i < bC; i++) {
                System.out.print(matrix[aR][i] + " ");
                if (i == bC - 1)
                    System.out.println();
            }
        } else if (bC == aC) {
            for (int i = 0; i < bR; i++) {
                System.out.print(matrix[i][aC] + " ");
                if (i == bR - 1)
                    System.out.println();
            }
        } else {
            int curR = aR;
            int curC = aC;
            while (curC != bC) {
                System.out.print(matrix[aR][curC] + " ");
                curC++;
            }
            while (curR != bR) {
                System.out.print(matrix[curR][bC] + " ");
                curR++;
            }
            while (curC != aC) {
                System.out.print(matrix[bR][curC] + " ");
                curC--;
            }
            while (curR != aR) {
                System.out.print(matrix[curR][aC] + " ");
                curR--;
            }
        }
    }

    /**
     * 旋转打印矩阵
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (aR <= bR) {
            rotateEdge(matrix, aR++, aC++, bR--, bC--);
        }
    }

    public static void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
        int times = d - b; // 每圈的循环长度
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
        }
    }

    /**
     * 之字形打印
     */
    public static void ZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) { // BC!= endC+1也可
            printZigZag(matrix, aR, aC, bR, bC, fromUp);
//			System.out.println();  //每行打印之子的一笔
            // A的列 到最后一列 行号++，列号不变
            // A的行 到最后一行，列号++，行号不变
            //B的列--> B的行 -->顺序不可调换:先判断该不该转弯
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;

            fromUp = !fromUp;
        }
        System.out.println();
    }


    private static void printZigZag(int[][] matrix, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (aR != bR + 1) {
                System.out.print(matrix[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(matrix[bR--][bC++] + " ");
            }
        }
    }

    /**
     * 公用的打印矩阵函数
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
                if (j == matrix[0].length - 1)
                    System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // printMatrix(matrix);
        // spiralPrintMatrix(matrix);

        // rotate(matrix);
        // printMatrix(matrix);

        ZigZag(matrix);
    }

}
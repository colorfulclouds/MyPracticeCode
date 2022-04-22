package com.hehe.ArrayAndList;

import java.util.*;

public class BiArray_Lands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("==================岛屿数量计数===================");
//        int res = countIsLands(arr, m, n); //影响第二个问题的结果
//        System.out.println(res);

        /**
         * 2 2
         * 1 1
         * 1 0
         *
         * 输出 3 只有一个岛屿 岛屿面积最大为3
         */
        System.out.println("==================岛屿面积最大值===================");
        int max = MaxAreaOfIsLand(arr, m, n);
        System.out.println(max);
    }


    /**
     * 岛屿数量计数
     *
     * @param arr
     * @param m
     * @param n
     * @return
     */
    private static int countIsLands(int[][] arr, int m, int n) {
        if (arr == null && arr[0] == null)
            return 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    res++;
                infect(arr, i, j, m, n);
            }
        }
        return res;
    }

    private static void infect(int[][] arr, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || arr[i][j] != 1) { //arr[i][j] == 0 || arr[i][j] == 2 也可
            return;
        }
        arr[i][j] = 2;

        infect(arr, i + 1, j, m, n);
        infect(arr, i - 1, j, m, n);
        infect(arr, i, j + 1, m, n);
        infect(arr, i, j - 1, m, n);
    }

    /**
     * 岛屿最大面积 zf
     * @param arr
     * @param n
     * @param m
     * @return
     */
//    private static int MaxAreaOfIsLand(int[][] arr, int n, int m) {
//        int[][] visit = new int[n][m];
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                max = Math.max(max, DFS(arr, visit, i, j));
//            }
//        }
//        return max;
//    }
//
//    private static int DFS(int[][] arr, int[][] visit, int i, int j) {
//        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visit[i][j] == 1 || arr[i][j] == 0)
//            return 0;
//        visit[i][j] = 1;
//        return 1 + DFS(arr, visit, i + 1, j)
//                + DFS(arr, visit, i - 1, j)
//                + DFS(arr, visit, i, j + 1)
//                + DFS(arr, visit, i, j - 1);
//    }


    /**
     * 改写 岛屿最大面积
      * @param arr
     * @param n
     * @param m
     * @return
     */
    private static int MaxAreaOfIsLand(int[][] arr, int n, int m) {
//        int[][] visit = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, DFS(arr, i, j));
            }
        }
        return max;
    }

    private static int DFS(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 1)//arr[i][j] == 2 || arr[i][j] == 0
            return 0;
        arr[i][j] = 2;
        return 1 + DFS(arr, i + 1, j)
                + DFS(arr, i - 1, j)
                + DFS(arr, i, j + 1)
                + DFS(arr, i, j - 1);
    }

}

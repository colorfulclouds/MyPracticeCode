package com.hehe.ArrayAndList;

import java.util.Scanner;

public class BiArray_Path {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int x1 = sc.nextInt();  //入口坐标
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();  //出口坐标
        int y2 = sc.nextInt();


        boolean[][] used = new boolean[M][N];
        dfs(x1, y1, used, x2, y2, 1, M * N);
        System.out.println(res);
    }

    private static void dfs(int x1, int y1, boolean[][] used, int x2, int y2, int tmp, int total) {
        if (x1 < 0 || x1 >= used.length || y1 < 0 || y1 >= used[0].length || used[x1][y1]) {
            return;
        }
        if (tmp == total && x1 == x2 && y1 == y2) {
            res++;
            return;
        }
        used[x1][y1] = true;
        dfs(x1 - 1, y1, used, x2, y2, tmp + 1, total);
        dfs(x1 + 1, y1, used, x2, y2, tmp + 1, total);
        dfs(x1, y1 - 1, used, x2, y2, tmp + 1, total);
        dfs(x1, y1 + 1, used, x2, y2, tmp + 1, total);
        used[x1][y1] = false;
    }


}

//4 4
//3 0
//0 3
//0

//4 4
//2 0
//3 0
//0
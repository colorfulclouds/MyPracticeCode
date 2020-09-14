package com.hehe.ArrayAndList;

import java.util.Scanner;

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

        int res = countIsLands(arr,m,n);
        System.out.println(res);
    }


    private static int countIsLands(int[][] arr,int m,int n) {
        if(arr == null && arr[0] == null)
            return 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1)
                    res++;
                infect(arr,i,j,m,n);
            }
        }
        return res;
    }

    private static void infect(int[][] arr, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || arr[i][j] != 1){
            return;
        }
        arr[i][j] = 2;

        infect(arr,i+1,j,m,n);
        infect(arr,i-1,j,m,n);
        infect(arr,i,j+1,m,n);
        infect(arr,i,j-1,m,n);
    }
}

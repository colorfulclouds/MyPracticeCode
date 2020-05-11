package com.hehe.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        System.out.println(Math.round(-1.5));
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

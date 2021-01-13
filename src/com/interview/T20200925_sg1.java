package com.interview;

public class T20200925_sg1 {
    public static void main(String[] args) {
        String[] s1 = {"1101","1010","1111","1110"};
        String[] s2 = {"ABCD","EFGH","IJKL","MNPQ"};
        System.out.println(rotatePassword(s1,s2));
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     *
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public static String rotatePassword(String[] s1, String[] s2) {
        int row = s1.length;
        int col = s1[0].length();
        int[][] key = new int[row][col];
        char[][] chars = new char[row][col];
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s2[0].length(); j++) {
                chars[i][j] = s2[i].charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1[0].length(); j++) {
                key[i][j] = s1[i].charAt(j)-'0';
                if(key[i][j] == 0)
                    sb.append(chars[i][j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            int[][] tmp = change(key);
            for (int k = 0; k < tmp.length; k++) {
                for (int j = 0; j < tmp[0].length; j++) {
                    if(tmp[k][j] == 0)
                        sb.append(chars[k][j]);
                }
            }
            key = tmp;
        }
        return sb.toString();
    }


    public static int[][] change(int [][] matrix){
        int[][] temp = new int[matrix[0].length][matrix.length];
        int dst = matrix.length-1;
        for (int i = 0; i < matrix.length; i++,dst--) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][dst] = matrix[i][j];
            }
        }
        return temp;
    }

}

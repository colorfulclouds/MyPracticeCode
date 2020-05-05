package com.hehe.ArrayAndList;


/**
 * 二维数组中查找是否存在某个数字
 */
public class FindInBiArray {
    public static boolean Find(int target, int[][] array) {
        boolean b = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target)
                    b = true;
            }
        }
        return b;

    }

    public static void main(String[] args) {
        FindInBiArray s = new FindInBiArray();
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        boolean b = Find(12, array);
        boolean b = FindInBiArray(array,9);
        System.out.println(b);
    }

    /*
     * 判断二维数组中是否有该整数
     * 思路：从右上角数字开始，若该数字大于所要查找的数字，剔除该数字所在的列，相反，剔除该数字所在行
     *       最后该数字在剩余数组的右上角
     * */
    public static boolean FindInBiArray(int a[][], int num) {
        int rows = a.length;
        int columns = a[0].length;
        boolean found = false;
        if (a != null && rows > 0 && columns > 0) {
            int p_row = 0;
            int p_column = columns - 1;

            //p_row是递增 [0-row]的角标都能满足
            //p_column是递减 p_column=0时要能进循环

            while (p_row < rows && p_column >= 0) {
                if (a[p_row][p_column] == num) {
                    found = true;
                    break;
                } else if (a[p_row][p_column] > num)
                    --p_column;
                else
                    ++p_row;
            }

        }
        return found;
    }
}

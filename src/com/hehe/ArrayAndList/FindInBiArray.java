package com.hehe.ArrayAndList;


/**
 * 二维数组中查找是否存在某个数字
 */
public class FindInBiArray {
    public boolean Find(int target, int[][] array) {
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
        boolean b = s.Find(12, array);
        System.out.println(b);
    }
}

package test;

/**
 * huawei 5.14面试题目
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int[] Merge(int[] arr1, int size1, int[] arr2, int size2, int[] c) {
        int index1 = 0, index2 = 0, i = 0;
        while (index1 < size1 && index2 < size2) {
            if (arr1[index1] <= arr2[index2]) {
                c[i++] = arr1[index1];
                index1++;
            } else {
                c[i++] = arr2[index2];
                index2++;
            }
        }
        while (index1 < size1) {
            c[i++] = arr1[index1];
            index1++;
        }
        while (index2 < size2) {
            c[i++] = arr2[index2];
            index2++;
        }
        return c;

    }
}

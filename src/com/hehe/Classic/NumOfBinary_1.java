package com.hehe.Classic;


import java.util.Scanner;

/**二进制中1的个数
 *
 */
public class NumOfBinary_1 {

        public static void main(String[] args) {
//            System.out.println(nums1(11));
//            System.out.println(nums2(11));

            Scanner sc = new Scanner(System.in);
            int input = Integer.parseInt(sc.nextLine());
            System.out.println(nums2(input));
        }


    /*有几个1 就循环几次
     * */
    public static int nums2(int n) {
        int count = 0;
        while(n>0){
            ++count;
            n = n & (n-1);
        }
        return count;
    }

    /*n位循环n次
     * */
    public static int  nums1(int n) {
        int count = 0;
        int flag = 1;
        while(flag>0){
            if((flag&n) > 0)
                count++;
            flag = flag<<1;
        }
        return count;
    }

}

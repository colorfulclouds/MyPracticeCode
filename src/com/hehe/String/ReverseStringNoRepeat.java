package com.hehe.String;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class ReverseStringNoRepeat {
    public static void main(String[] args) {
        reverse("123434232");
        reverse("12332");
    }

    //36ms的方法
    public static void reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int arr1[] = new int[10];

        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 48;
            if (arr1[index] == 0) {  //字符’0’的ascii码是48，数字0的值是0
                sb.append(s.charAt(i));
                arr1[index]++;
            }
        }

        System.out.println(Integer.parseInt(sb.toString()));
    }


    //测试输出
//    输入    1000
//    输出    1000
//            1000
    public static void test(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) - 48);
        }
    }


}

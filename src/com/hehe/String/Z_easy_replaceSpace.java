package com.hehe.String;


import java.util.Scanner;

public class Z_easy_replaceSpace {
    /**
     * 字符串中的空格替换成  "%20"
     */
//    public static void main(String[] args) {
//        System.out.println(replaceSpace(new StringBuffer("we are family.")));
//    }
//
//    public static String replaceSpace(StringBuffer str) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i <str.length(); i++) {
//            if(String.valueOf(str.charAt(i)).equals(" ")){
//                sb.append("%20");
//            }else
//                sb.append(str.charAt(i));
//        }
//        return sb.toString();
//
//    }
//===================================================================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(input.replaceAll("([0-9]+)", "*$1*")); //把所有的数字段提取出来，前后加上星号再放回去
        }
    }


    /**
     * 数组类型的 从尾到头复制 遇到空格插入
     *
     * 见 package com.hehe.ArrayAndList.replaceBlank_easy;
     */
}

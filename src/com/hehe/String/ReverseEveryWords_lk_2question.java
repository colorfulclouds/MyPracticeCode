package com.hehe.String;

/**
 * lk557
 * Let's take LeetCode contest
 * s'teL ekat edoCteeL tsetnoc
 *
 *
 * lk151
 * the sky is blue
 * blue is sky the
 */
public class ReverseEveryWords_lk_2question {

    public static void main(String[] args) {
//        System.out.println(reverseWords_557(new String("Let's take LeetCode contest")));
        // s'teL ekat edoCteeL tsetnoc
        System.out.println(reverseWords_151(new String("example   good a")));

    }

    public static String reverseWords_557(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(new StringBuilder(w).reverse().toString() + " ");
        }
        return sb.toString().trim();  //trim() 去掉字符换两端多余的空格
    }

    public static String reverseWords_151(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]+" ");
        }
        return sb.toString().trim();
    }

    //正则匹配所有空白
//[\s]表示，只要出现空白就匹配
//[\S]表示，非空白就匹配


}

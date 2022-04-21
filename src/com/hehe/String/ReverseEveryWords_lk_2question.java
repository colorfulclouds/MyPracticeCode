package com.hehe.String;

/**
 * lk557
 * Let's take LeetCode contest
 * s'teL ekat edoCteeL tsetnoc
 *
 * lk151
 * the sky is blue
 * blue is sky the
 */
public class ReverseEveryWords_lk_2question {

    public static void main(String[] args) {
        System.out.println(reverseWords_557(new String("Let's take LeetCode contest")));
        // s'teL ekat edoCteeL tsetnoc
        System.out.println(reverseWords_151(new String("example   good a")));
        //a good example

        StringBuilder sb = new StringBuilder();
        sb.append("a ");
        sb.append("bc ");
        sb.append("cd ");
        System.out.println(sb);
        System.out.println(sb.reverse());

        String s = "abcdefg";
        System.out.println(leftRotate(s, 2));
    }

    /**
     * 反转每一个单词内部
     *
     * @param s
     * @return
     */
    public static String reverseWords_557(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
//        for (String w : words) {
//            sb.append(new StringBuilder(w).reverse().toString() + " ");
//        }
//        return sb.toString().trim();  //trim() 去掉字符换两端多余的空格
        for (String w : words) {
            sb.append(new StringBuilder(w).reverse() + " ");
        }
        return sb.toString().trim();
    }

    /**
     * 反转所有单词
     * jz_58-1
     *
     * @param s
     * @return
     */
    public static String reverseWords_151(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }

    //正则匹配所有空白
//[\s]表示，只要出现空白就匹配
//[\S]表示，非空白就匹配

    /**
     * jz_58-2
     * 输入 abcdefg 2
     * 输出 cdefgab
     * 左旋2个字母
     * 另一种思路：1、先前两个反转，剩余反转，结果为：bagfedc 2、再全部反转，结果为cdefgab
     *
     * @param s
     * @param k
     * @return
     */
    public static String leftRotate(String s, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(2));
        sb.append(s.substring(0, 2));
        return sb.toString();
    }


}

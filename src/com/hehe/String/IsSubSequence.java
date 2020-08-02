package com.hehe.String;


/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 */
public class IsSubSequence {

    public static void main(String[] args) {
        String s = "abcde";
        String t = "ace";
        System.out.println(isSubsequence(s,t)); //true

        String s1 = "abcde";
        String t1 = "acf";
        System.out.println(isSubsequence(s1,t1)); //false

    }

    public static boolean isSubsequence(String s, String t) {
        boolean[][] table = new boolean[t.length() +1][s.length()+1];

        for (int col = 0; col <= s.length(); col++) {
            table[0][col] = true;
        }
        for (int row = 1; row <= t.length(); row++) {
            for (int col = 1; col <= s.length(); col++) {
                char chr1 = t.charAt(row-1);
                char chr2 = s.charAt(col-1);
                //自己的办法总是很笨 -_-!
//                if(chr1 == chr2){
//                    table[row][col] = table[row - 1][col - 1];
//                    if(table[row][col] == true)
//                        for (int i = col+1; i <=s.length() ; i++) {
//                            table[row][i] = true;
//                        }
//                    break;
//                }
//                else
//                    table[row][col] = false;

                if (chr1 == chr2)
                    table[row][col] = table[row - 1][col - 1];
                else
                    table[row][col] = table[row][col - 1];

            }
        }
        return table[t.length()][s.length()];

    }

    //如果仅依赖前一个状态 可改为一维数组



}



package com.hehe.String;


/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 */
public class SubSeq_IsSubSeq {

    public static void main(String[] args) {
        String s = "abcde";
        String t = "ace";
        System.out.println(isSubsequence(s, t)); //true

        String s1 = "abcde";
        String t1 = "cf";
        System.out.println(isSubsequence(s1, t1)); //false
        System.out.println("++++++++++");

        System.out.println(isSubsequence01(s, t)); //false
        System.out.println(isSubsequence01(s1, t1)); //false

    }

    /**
     * 是否是子序列 (最简单好理解的做法)
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) { //s 长 t 短
        if(t.length() == 0) //空串是任何串的子序列
            return true;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }
        return j == t.length();

    }

    /**
     * 判断是否是子序列（递归）
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence01(String s, String t) {
        String tmp = "";// = new String();
        int i = 0;
        return isSubCore(s, i, tmp, t);

    }

    private static boolean isSubCore(String s, int i, String tmp, String t) {
        if (tmp.equals(t))
            return true;
        if (i < s.length())
            return isSubCore(s, i + 1, tmp, t) || isSubCore(s, i + 1, tmp + s.charAt(i), t);
        else
            return false;

    }
    /**
     * 是否是子序列（动态规划）
     * 如果仅依赖前一个状态 可改为一维数组
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence02(String s, String t) {
        boolean[][] table = new boolean[t.length() + 1][s.length() + 1];

        for (int col = 0; col <= s.length(); col++) {
            table[0][col] = true;
        }
        for (int row = 1; row <= t.length(); row++) {
            for (int col = 1; col <= s.length(); col++) {
                char chr1 = t.charAt(row - 1);
                char chr2 = s.charAt(col - 1);
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

}



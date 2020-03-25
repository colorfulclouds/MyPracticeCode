package com.hehe.Classic;
/*题目描述：Z字形排列变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * Z字形排列：
 *
 * L   C   I   R
   E T O E S I I G
   E   D   H   N
 *
 * 示例 1:

	输入: s = "LEETCODEISHIRING", numRows = 3
	输出: "LCIRETOESIIGEDHN"
   示例 2:

	输入: s = "LEETCODEISHIRING", numRows = 4
	输出: "LDREOEIIECIHNTSG"
 *
 * L     D     R
   E   O E   I I
   E C   I H   N
   T     S     G
 * */

public class Z_ShapeChange {

    public static void main(String[] args) {
        String s ="LEETCODEISHIRING";
        int numRows = 3;
        String ret = convert(s, numRows);
        System.out.println(ret);

    }

    /**
     * 将之字形字符串按行打印出来
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        //循环长度：
        int cycleLen = 2 * numRows - 2;

        //按行访问
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {

                ret.append(s.charAt(j + i));
                //非第一行和非最后一行时 s 的下标
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}

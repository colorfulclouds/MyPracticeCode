package com.hehe.String;

public class AddBinaryStrSeq {
    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
        System.out.println(addBinary("1010","1011"));
    }

    /**
     * 二进制字符串相加
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        //有位数限制 不能直接用整型
//        int aa = Integer.parseInt(a,2);
//        int bb = Integer.parseInt(b,2);
//        String s = Integer.toString(aa+bb,2);
//        return s;

        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length()-1,j = b.length()-1; i >= 0 || j >= 0; i--,j--) {
            sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        sb.append(carry == 1 ? carry : 0);
        return sb.reverse().toString();

    }
}

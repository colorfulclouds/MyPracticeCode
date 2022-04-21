package com.hehe.String;

public class AddBinaryStrSeq {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("0", "0"));
    }

    /**
     * 二进制字符串相加
     * package com.hehe.LinkedList.AddTowNum 类似
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();

    }
}

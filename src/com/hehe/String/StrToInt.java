package com.hehe.String;

/**
 * "+1230"
 * 1230
 *
 * "-12"
 * -12
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(StrToInt("+123"));
    }

    public static int StrToInt(String str) {
        if (str == null)
            return 0;
        int res = 0;
        int symbol = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(0) == '+') {
                continue;
            } else if (str.charAt(0) == '-' && i == 0) {
                symbol = -1;
            } else if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                res = res * 10 + (str.charAt(i) - '0');
            } else {
                res = 0;
                break;
            }


        }
        return symbol * res;
    }
}

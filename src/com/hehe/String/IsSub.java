package com.hehe.String;

public class IsSub {
    public static void main(String[] args) {
        System.out.println(indexOf("abc","bc"));
    }

    public static int indexOf (String s, String pattern) {
        int index = -1;
        int lim = s.length() - pattern.length();
        int k = 0;
        while (k <= lim) {
            for (int j = 0; j < pattern.length(); j++) {
                if(s.charAt(k + j) == pattern.charAt(j) && j == 0){
                    index = k+j;
                }
                if (s.charAt(k + j) != pattern.charAt(j)) {
                    index = -1;
                    break;
                }
                if(j == pattern.length() - 1 && s.charAt(k + j) == pattern.charAt(j))
                    return index;

            }
            k++;
        }
        return index;
    }
}

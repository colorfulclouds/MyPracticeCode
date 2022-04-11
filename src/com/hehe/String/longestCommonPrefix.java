package com.hehe.String;


class longestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[3];
//        strs[0] = "ab";
//        strs[1] = "abc";
//        strs[2] = "abcdef";
        strs[0] = "tif";
        strs[1] = "tif";
        strs[2] = "tif";
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix01(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) //若为空 直接返回空串 没必要再比了
                return ans;
        }
        return ans;
    }

    /**
     * 注释加优化版本
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix01(String[] strs) {
        if (strs.length == 0)
            return "";
        // 初始值为首位元素
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 挨着对比
            while (j < res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // substring 是左闭右开的
            res = res.substring(0, j);
            if (res.equals("")) //若为空 直接返回空串 没必要再比了
                return res;
        }
        return res;
    }


}
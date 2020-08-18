package com.hehe.String;

public class SubStringQs {

    public static void main(String[] args) {
        String s = "aabbaabaa";


        int res = characterReplacement(s, 2);
        int res1 = characterReplacement(s, 1);
        System.out.println(res);
        System.out.println(res1);
    }


    /**
     * 最长完美字串
     * 滑动窗口
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;

//        int res = 0; //可以定义结果变量 方便理解

        for (right = 0; right < chars.length; right++) { //窗口右侧一直往右移
            int index = chars[right] - 'a';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) { //窗口内替换后仍无法达到历史最大完美子串长度 故窗口左侧边界收缩
                map[chars[left] - 'a']--;
                left++;
            }
//            else
//                res = Math.max(right - left + 1, res);

        }
        return chars.length - left;
//        return res;
    }
}

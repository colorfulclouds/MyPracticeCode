package com.hehe.String;

public class SubStringQs {

    public static void main(String[] args) {
        String s = "aabbaabaa";
        int m = 2;
//        int res = characterReplacement(s, m);
        int res = characterReplacement02(s, 2);
        int res1 = characterReplacement02(s, 1);
        System.out.println(res);
        System.out.println(res1);
    }
    /**
     * 最长完美字串
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement02(String s, int k) {
        int[] map = new int[26];
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'a';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'a']--;
                left++;
            }
        }
        return chars.length - left;
    }
}

package com.hehe.String;

import java.util.HashMap;
import java.util.Set;

public class SubStringQs {

    public static void main(String[] args) {
        String s = "aabbaabaa";


//        System.out.println("==========最长完美字串===========================");
//        int res = characterReplacement(s, 2);
//        int res1 = characterReplacement(s, 1);
//        System.out.println(res);
//        System.out.println(res1);

        System.out.println("==========一串字符能组成的 最长回文串============");
        String ss = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(ss));
        System.out.println(longestPalindrome("abccccdd"));


    }

    /**
     * 一串字符能组成的 最长回文串
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> set = map.keySet();
        int res = 0;
        for (Character c : set) {
            int num = map.get(c);
            res += num / 2 * 2;
            if (res % 2 == 0 && num % 2 != 0)
                res++;
        }
        return res;

    }

    /**
     * 最长完美字串
     * 滑动窗口
     *
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

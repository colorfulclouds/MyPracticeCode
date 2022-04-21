package com.hehe.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("34");
        for (String s : strings) {
            System.out.println(s);
        }

    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        }; //" ", "*",

        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = letter_map[digits.charAt(i) - '2']; //当前数字对应的字符串
            int size = res.size();

            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;

    }
}

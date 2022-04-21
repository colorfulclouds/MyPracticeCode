package com.hehe.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入 n
 * 输出 n 对 括号的所有有效序列
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }


    }

    /**
     * 递归 generateCore
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;

        generateCore(list, n, n, "");
        return list;
    }

    private static void generateCore(List<String> list, int left, int right, String curStr) {
        if (left > right)  //已经有的字符串序列 左括号剩余一定要比右括号少 否则不是有效括号序列
            return;
        if (left == 0 && right == 0) {
            list.add(curStr);
            return;
        }
        if (left > 0)
            generateCore(list, left - 1, right, curStr + "(");
        if (right > 0)
            generateCore(list, left, right - 1, curStr + ")");
    }


    /**
     * 另一种思路
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis01(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        StringBuilder path = new StringBuilder();
        dfs(path, n, n, res);
        return res;
    }

    private void dfs(StringBuilder path, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
            res.add(path.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            path.append("(");
            dfs(path, left - 1, right, res);
            path.deleteCharAt(path.length() - 1); //path 在给别的分支回溯需要删除 最后一个字符
        }

        if (right > 0) {
            path.append(")");
            dfs(path, left, right - 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

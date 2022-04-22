package com.hehe.HuaWei;

import java.util.*;
import java.util.Scanner;

/**
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * <p>
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 * <p>
 * 数据范围：运算过程中和最终结果均满足 |val| \le 2^{31}-1 \∣val∣≤2^31
 * −1  ，即只进行整型运算，确保输入的表达式合法
 * 输入描述：
 * 输入算术表达式
 * <p>
 * 输出描述：
 * 计算出结果值
 * <p>
 * 示例1
 * 输入：
 * 400+5
 * 复制
 * 输出：
 * 405
 *
 * 3+2*{1+2*[-4/(8-6)+7]}
 */
public class GetResultFromExpression_difficult {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        //将其他括号，替换成小括号
//        s = s.replace("{", "(");
//        s = s.replace("[", "(");
//        s = s.replace("}", ")");
//        s = s.replace("]", ")");
//        System.out.println(slove(s));
//    }
//    public static int slove(String s) {
//        Stack<Integer> stack = new Stack<>();
//        int n = s.length();
//        char[] chs = s.toCharArray();
//        //初始化符号为'+'
//        char sign = '+';
//        //记录数字
//        int number = 0;
//        for (int i = 0; i < n; i++) {
//            char ch = chs[i];
//            //当前字符是空格，跳过
//            //if (ch == ' ') continue;
//            //当前字符是数字，拼数字
//            if (Character.isDigit(ch)) {
//                number = number * 10 + ch - '0';
//            }
//            //如果当前字符是小括号
//            if (ch == '(') {
//                //移到小括号后一位字符
//                int j = i + 1;
//                //统计括号的数量
//                int count = 1;
//                while (count > 0) {
//                    //遇到右括号，括号数-1
//                    if (chs[j] == ')')
//                        count--;
//                    //遇到左括号，括号数+1
//                    if (chs[j] == '(')
//                        count++;
//                    j++;
//                }
//                //递归，解小括号中的表达式
//                number = slove(s.substring(i + 1, j - 1));
//                i = j - 1;
//            }
//            //遇到符号，将数字处理后放进栈
//            if (!Character.isDigit(ch) || i == n - 1) {
//                //如果是'+',直接入栈
//                if (sign == '+') {
//                    stack.push(number);
//                }
//                //如果是'-',数字取相反数在入栈
//                else if (sign == '-') {
//                    stack.push(-1 * number);
//                }
//                //如果是'*',弹出一个数字乘后放入栈
//                else if (sign == '*') {
//                    stack.push(stack.pop() * number);
//                }
//                //如果是'/',弹出一个数字/后放入栈
//                else if (sign == '/') {
//                    stack.push(stack.pop() / number);
//                }
//                //更新符号
//                sign = ch;
//                //刷新数字
//                number = 0;
//            }
//        }
//        //栈中数字求和得到结果
//        int ans = 0;
//        while (!stack.isEmpty()) {
//            ans += stack.pop();
//        }
//        return ans;
//    }
    public static void compute(Stack<Integer> st1, Stack<Character> st2) { //根据栈顶运算符弹出栈顶两个元素进行运算
        int b = st1.peek();
        st1.pop();
        int a = st1.peek();
        st1.pop();
        char op = st2.peek(); //栈顶运算符
        st2.pop();
        if (op == '+') a = a + b; //加
        else if (op == '-') a = a - b; //减
        else if (op == '*') a = a * b; //乘
        else if (op == '/') a = a / b; //除
        st1.push(a);
    }

    public static boolean priority(char m, char n) { //比较运算符优先级
        if (m == '(') //括号优先级最高
            return false;
        else if ((m == '+' || m == '-') && (n == '*' || n == '/')) //加减法小于乘除法
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            s = s.replace("{", "(");
            s = s.replace("[", "(");
            s = s.replace("}", ")");
            s = s.replace("]", ")");
            Stack<Integer> st1 = new Stack(); //记录运算数字
            Stack<Character> st2 = new Stack<>(); //记录运算符
            st2.push('('); //整个运算式添加括号
            s += ')';
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') //如果是左括号都在运算符栈加入(
                    st2.push(s.charAt(i));
                else if (s.charAt(i) == ')') { //遇到右括号
                    while (st2.peek() != '(') { //弹出开始计算直到遇到左括号
                        compute(st1, st2);
                    }
                    st2.pop(); //弹出左括号
                } else if (flag) { //运算符
                    while (priority(st2.peek(), s.charAt(i))) { //比较运算优先级
                        compute(st1, st2); //可以直接计算
                    }
                    st2.push(s.charAt(i)); //需要将现阶段加入栈中等待运算
                    flag = false;
                } else { //数字
                    int j = i; //记录起始
                    if (s.charAt(j) == '-' || s.charAt(j) == '+') //正负号
                        i++;
                    while (Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    String temp = s.substring(j, i);
                    st1.push(Integer.parseInt(temp)); //截取数字部分，转数字
                    i--;
                    flag = true; //数字结束，下一次flag为true就是运算符了
                }
            }
            System.out.println(st1.peek()); //输出
        }
    }

}

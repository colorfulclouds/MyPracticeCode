package com.hehe.Stack_Pra;

/*数组实现栈
 *
 * */
public class ArrMinStack {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(6);
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
    }

    /**
     * 自定义数组实现的 栈 的数据结构
     */
    static class Stack {
        //数组的声明
        int[] a = new int[1000];
        int cnt;

        //初始化数据结构
        public Stack() {
            cnt = 0;
        }

        public void push(int x) {
            a[cnt++] = x;
        }

        public void pop() {
            cnt--;
        }

        public int top() {
            return a[cnt - 1];
        }

        public int getMin() {
            int min = a[0];
            for (int i = 1; i < cnt; i++) {
                if (min > a[i]) {
                    min = a[i];
                }
            }
            return min;
        }

    }

}




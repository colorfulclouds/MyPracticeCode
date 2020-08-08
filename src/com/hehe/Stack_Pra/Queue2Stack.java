package com.hehe.Stack_Pra;

import java.util.Stack;

public class Queue2Stack {

    public static void main(String[] args) {
        queue2Stack myStack = new queue2Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        myStack.push(5);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }

    public static class queue2Stack {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);

        }

        public int pop() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    int tmp = stack1.pop();
                    stack2.push(tmp);
                }
                if (!stack2.isEmpty()) {
                    return stack2.pop();
                }
                return -1;

            }
        }
    }

}

package com.hehe.Stack_Pra;

import java.util.Stack;

/**
 * 包含min函数的Stack
 */
public class StackWithMin {
    Stack<Integer> A,B;
    public void MinStack(){
        A = new Stack<>();
        B = new Stack<>();
    }

    public void Push(int val){
        A.push(val);
        if(B.isEmpty() || B.peek()>val)
            B.push(val);
        else
            B.push(B.peek());
    }

    public void Pop(){
        A.pop();
        B.pop();

//        if(!A.isEmpty() && A.pop() == B.peek())
//            B.pop();

    }

    public int Top(){
        return A.peek();
    }

    public int Min(){
        return B.peek();
    }



}

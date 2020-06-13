package com.hehe.Stack_Pra;

import java.util.Stack;

/**
 *输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5}是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
 * 就不可能是该压栈序列的弹出序列。
 */

//执行结果：
//        通过
//        显示详情
//        执行用时 :2 ms, 在所有 Java 提交中击败了96.60%的用户
//        内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
public class IsValidSer {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1}; //true
        int[] c = {4,3,5,1,2}; //false
        int[] d = {4,5,3,1,2}; //false
        int[] e = {4,5,3,2,1}; //true
        int[] x = {2,1,3,0};
        int[] y = {1,0,3,2}; //true
        int[] aa = {1,0,2};
        int[] bb = {2,1,0}; //false


//        System.out.println(IsValidSer(a,b));
//        System.out.println(IsValidSer(a,c));
//        System.out.println(IsValidSer(a,d));
//        System.out.println(IsValidSer(a,e));
//        System.out.println(IsValidSer(x,y));
//        System.out.println(IsValidSer(aa,bb));

        System.out.println(isValid(a,b));
        System.out.println(isValid(a,c));
        System.out.println(isValid(a,d));
        System.out.println(isValid(a,e));
        System.out.println(isValid(x,y));
        System.out.println(isValid(aa,bb));

    }


    /**
     * 四两拨千斤解法
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean isValid(int[] pushed,int[] popped){
        Stack<Integer> stack =new Stack<>();
        int i=0;
        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() ==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 最菜解法
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean IsValidSer(int[] pushed,int[] popped){
        Stack<Integer> A = new Stack<>();

        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            int cur = popped[i];
            if(A.isEmpty()){
                while(pushed[index] != cur && index<pushed.length){
                    A.push(pushed[index]);
                    index++;
                }
                if(index<pushed.length-1)
                    index++;
                continue;
            }else if(!A.isEmpty()){

                if(A.peek()!=cur){
//                    if(pushed[index] == cur && index<pushed.length-1){
//                        index++;
//                        continue;
//                    }else if(pushed[index] == cur)
//                        continue;

                    while(pushed[index] != cur && index<pushed.length-1){
                        A.push(pushed[index]);
                        index++;
                    }
                    if(index==pushed.length-1 && pushed[index] != cur)
                        return false;
                    else if(pushed[index] == cur && index<pushed.length-1) {
                        index++;
                        continue;
                    }
                    else if(pushed[index] == cur)
                        continue;

                }else if(A.peek() == cur){
                    A.pop();
                    continue;
                }


            }
        }
        return true;
    }
}

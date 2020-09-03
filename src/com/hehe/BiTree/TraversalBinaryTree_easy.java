package com.hehe.BiTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/mo-fang-di-gui-zhi-bian-yi-xing-by-sonp/

//完全模仿递归，不变一行。秒杀全场，一劳永逸！！
public class TraversalBinaryTree_easy {
    public static void main(String[] args) {

    }

    /**
     * 前序
     * 根左右  -> 右左根
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> res = new ArrayList<>();  //保存结果
        Stack<TreeNode> stack = new Stack<>();   //调用栈
        stack.push(root);    //先将根结点入栈

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();   //弹出结点并判断是否访问过
            //非空说明没访问过，然后右结点入栈，左结点入栈，最后根节点入栈，并入栈一个空结点
            //表明当前结点以访问过
            if (t != null) {
                if (t.right != null) stack.push(t.right);
                if (t.left != null) stack.push(t.left);
                stack.push(t);
                stack.push(null);
            } else {
                res.add(stack.pop().val);    //如果弹出结点为空结点，表明当前栈顶结点已访问过
            }
        }
        return res;
    }

    /**
     * 中序
     * 左根右 -> 右根左
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();  //保存结果
        Stack<TreeNode> stack = new Stack<>();   //调用栈
        stack.push(root);    //先将根结点入栈

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                if (t.right != null) stack.push(t.right);
                stack.push(t);  //在左结点之前重新插入该结点，以便在左结点之后处理（访问值）
                stack.push(null); //空结点随之入栈，标识已经访问过，但还没有被处理（还可以进行额外操作）
                if (t.left != null) stack.push(t.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

    /**
     * 后序
     * 左右根 -> 根右左
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();  //保存结果
        Stack<TreeNode> stack = new Stack<>();   //调用栈
        stack.push(root);    //先将根结点入栈

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                stack.push(t);   //完全模拟递归，真的是秒杀全场
                stack.push(null);    //！完美
                if (t.right != null) stack.push(t.right);
                if (t.left != null) stack.push(t.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }
}

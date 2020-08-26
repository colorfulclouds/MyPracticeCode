package com.hehe.BiTree;

public class HasSubTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(hasSubTree(root1,root2));


    }

    /**
     * root2 是否是 root1 的子结构
     * @param root1
     * @param root2
     * @return
     */
    static boolean hasSubTree(TreeNode root1,TreeNode root2){
        boolean res = false;

        if(root1 == null || root2 == null) //定义空树不是任何树的子树
            return false;
        if(root1!=null && root2!=null){
            if(root1.val == root2.val)   //结点值的判断 需要改进 因为如果是float/double这些小数时，计算机表示有误差
                res =  DoseTree2InTree1(root1,root2); //根节点相等继续判断其它结点
            if(!res)
                return hasSubTree(root1.left,root2) || hasSubTree(root1.right,root2);  //依次判断左,右结点
        }

        return res;
    }

    /**
     * 根节点相等继续判断其它结点
     * @param root1
     * @param root2
     * @return
     */
    private static boolean DoseTree2InTree1(TreeNode root1, TreeNode root2) {
        if(root2 == null)  //
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return DoseTree2InTree1(root1.left,root2.left) && DoseTree2InTree1(root1.right,root2.right);



    }

    /**
     * 判断两个小数是否相等 只能判断他们的差的绝对值是不是在一个很小的范围
     * |a-b|<0.0000001
     * @param a
     * @param b
     * @return
     */
    boolean Equal(double a,double b){
        if(a-b>-0.0000001 && b-a<0.0000001)
            return true;
        else
            return false;
    }


//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
}

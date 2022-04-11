package com.hehe.BiTree;

public class BiTree_Feature {

    /**
     * 1 最大深度
     *
     * @param root
     * @return
     */
    public static int max_depth(TreeNode root) {
        if (root == null)
            return 0;
        int depth_left = max_depth(root.left);
        int depth_right = max_depth(root.right);
        return Math.max(depth_left, depth_right) + 1;
//        return depth_left > depth_right ? depth_left + 1 : depth_right + 1;    // 同上
    }


    /**
     * 2 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
     * <p>
     * 若只有根结点和右结点，则最小深度是根结点到最近的叶子结点 ：右结点的 最短路径上结点的数量
     *
     * @param root
     * @return
     */
    public static int min_depth(TreeNode root) {
        if (root == null) {  //无根
            return 0;
        }
        int depth_left = min_depth(root.left);
        int depth_right = min_depth(root.right);
        return Math.min(depth_left, depth_right) + 1;
    }


    /**
     * 3 判断是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public static boolean IsBalance(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 后序递归判断是否是平衡二叉树
     * 是返回二叉树的最大深度，否返回 -1
     * @param root
     * @return
     */
    public static int recur(TreeNode root) {
        if (root == null)
            return 0;

        int left = recur(root.left);
        if (left == -1)
            return -1;

        int right = recur(root.right);
        if (right == -1)
            return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 4 是否是镜像二叉树
     *
     * @param root
     * @return
     */
    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null)
            return true;
        return Helper(root.left, root.right);
    }

    private static boolean Helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)  //均空   //！
            return true;
        if (left == null || right == null)  //一个为空
            return false;

        //镜像的判断（互为镜像的两个结点继续判断： A结点 的左子结点 和 B结点的右子结点
        //                                 A结点 的右子结点 和 B结点的左子结点）
        return left.val == right.val
                && Helper(left.left, right.right)
                && Helper(left.right, right.left);
    }

    /**
     * 5 求一颗二叉树的镜面反转树
     *
     * @param root
     */
    static TreeNode Mirror(TreeNode root) {
        if (root == null)
            return root;
//        if(root.left == null && root.right == null)
//            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
        return root;
    }


    /**
     * 6 叶子节点个数
     *
     * @param head
     * @return
     */
    public static int leafs(TreeNode head) {
        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 1;
        }
        return leafs(head.left) + leafs(head.right);
    }

    public static void main(String[] args) {
        System.out.println("========================================最小/最大深度=======================================");
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(3);
        head.left.right.left = new TreeNode(5);
        head.left.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println("min_depth1: " + min_depth(head));
        System.out.println("min_depth2: " + min_depth(root));

        System.out.println("max_depth2： " + max_depth(head));
        System.out.println("max_depth1： " + max_depth(root));


        System.out.println("=====================3 后序递归判断是否是平衡二叉树=======================");
        TreeNode root1 = new TreeNode(3);
        System.out.println(IsBalance(root1));

        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(4);  //注释便不平衡的树
        root1.left.left = new TreeNode(4);
        System.out.println(IsBalance(root1));

        System.out.println("===============================4 是否是镜像二叉树============================");
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(3);

        System.out.println(isSymmetricTree(root2));
        System.out.println("=============================5 求一颗二叉树的镜面反转树=====================");

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(4);
        root3.right.left = new TreeNode(4);
        root3.right.right = new TreeNode(3);
        TreeNode res = Mirror(root3);
        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);


        System.out.println("=============================叶子节点个数=====================");
        TreeNode head2 = new TreeNode(5);
        head2.left = new TreeNode(3);
        head2.right = new TreeNode(8);
        head2.left.left = new TreeNode(2);
        head2.left.right = new TreeNode(4);
        head2.left.left.left = new TreeNode(1);
        head2.right.left = new TreeNode(7);
        head2.right.left.left = new TreeNode(6);
        head2.right.right = new TreeNode(10);
        head2.right.right.left = new TreeNode(9);
        head2.right.right.right = new TreeNode(11);


        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(4);
        root4.left.left.left = new TreeNode(4);
        root4.right = new TreeNode(3);

        System.out.println(leafs(head2));
        System.out.println(leafs(root4));


    }

}

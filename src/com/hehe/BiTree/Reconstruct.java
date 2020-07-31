package com.hehe.BiTree;


import java.util.HashMap;

/**
 * 中序和前序序列 构建出树
 */
public class Reconstruct {

    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode resTree = Construct(pre,in);
        System.out.println(resTree.val);


    }


    public static TreeNode Construct(int[] pre,int[] in){
        if(pre.length <= 0 || in.length <= 0)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) { //根据查找目的村value
            map.put(in[i],i);
        }
        
        return ConstructCore(pre,0,pre.length-1,in,0,in.length-1,map);
        
    }

    public static TreeNode ConstructCore(int[] pre,int pi,int pj,int[] in,int ii,int ij,HashMap<Integer,Integer> map){
        if(pi > pj)
            return null;
        TreeNode root = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        root.left = ConstructCore(pre,pi+1,pi+index-ii,in,ii,index-1,map);
        root.right = ConstructCore(pre,pi+index-ii+1,pj,in,index +1,ij,map);

        return root;
    }

}

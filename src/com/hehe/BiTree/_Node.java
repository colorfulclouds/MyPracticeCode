package com.hehe.BiTree;

public class _Node {
    private int data;
    private _Node leftNode;
    private _Node rightNode;

    public _Node(int data, _Node leftNode, _Node rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public _Node getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(_Node leftNode) {
        this.leftNode = leftNode;
    }
    public _Node getRightNode() {
        return rightNode;
    }
    public void setRightNode(_Node rightNode) {
        this.rightNode = rightNode;
    }
}

package com.hehe.LinkedList;

/**
 * 复杂链表的复制
 */
public class Clone {

    public static void main(String[] args) {

        ComplexLinkedList head = new ComplexLinkedList(1);
        head.next = new ComplexLinkedList(2);
        head.next.next = new ComplexLinkedList(3);
        head.sibling = head.next.next;
        head.next.next.next = new ComplexLinkedList(4);

        CloneNodes(head);
        CloneSiblings(head);
        ComplexLinkedList list = SplitLinkedList(head);
        while(list!=null){
            if(list.sibling!=null){
                System.out.print("my value is: " + list.value + " ");
                System.out.println("my sibling is: " + list.sibling.value);
            }else{
                System.out.println("my value is: " + list.value + " ");
            }
            list = list.next;
        }


    }

    /**
     * 1、复制全部的 next 结点信息，复制结点插在原节点后
     * 2、复制全部的 sibling 结点信息
     * 3、拆链表成两个
     */

    public static void CloneNodes(ComplexLinkedList head) {
        ComplexLinkedList pNode = head;
        while (pNode != null) {
            ComplexLinkedList Node = new ComplexLinkedList(pNode.value);
            Node.next = pNode.next;
            pNode.next = Node;
            pNode = Node.next;
        }
    }

    public static void CloneSiblings(ComplexLinkedList head) {
        ComplexLinkedList pNode = head;
        while (pNode != null) {
            ComplexLinkedList Node = pNode.next;
            if (pNode.sibling != null) {
                Node.sibling = pNode.sibling.next;
            }
            pNode = Node.next;
        }
    }

    public static ComplexLinkedList SplitLinkedList(ComplexLinkedList head){
        ComplexLinkedList pNode = head;
        ComplexLinkedList pClonedHead = null;
        ComplexLinkedList pClone = null;
        if(pNode!=null){
            pClonedHead = pNode.next;
            pClone = pNode.next;
        }

        while (pNode!=null){
            if(pNode.next.next!=null){
                pNode.next = pClone.next;
                pNode = pClone.next;
                pClone.next = pNode.next;
                pClone = pNode.next;
            }else{
                pNode.next = null;
                pClone.next = null;
                break;
            }

        }
        return pClonedHead;

    }

    public static class ComplexLinkedList {
        int value;
        ComplexLinkedList next;
        ComplexLinkedList sibling;

        ComplexLinkedList(int value) {
            this.value = value;
        }
    }

}

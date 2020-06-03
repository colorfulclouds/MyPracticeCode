package com.hehe.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 数组实现栈
 */
public class QueueBasic {
    public static void main(String[] args) {
//        Queue queue = new Queue(4);
//        queue.Push(1);
//        queue.Push(2);
//        int top = queue.Top();
//        System.out.println(top);
//        System.out.println(queue.Pop());
////        System.out.println(queue.Pop());
//        System.out.println(queue.count);
//        queue.Clear();
//        System.out.println(queue.count);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n!=0){
            int op = Integer.parseInt(sc.nextLine());
            Queue queue = new Queue(op);
            while(op!=0){
//            String non = sc.nextLine(); //上个输入如果是 sc.nextInt() 接收上一行的剩余空行
                String[] str = sc.nextLine().split(" ");
                String part1 = str[0];
                if(part1.equals("PUSH")){
                    int part2 = Integer.parseInt(str[1]);
                    queue.Push(part2);
                }else if(part1.equals("TOP")){
                    System.out.println(queue.Top());
                }else if(part1.equals("POP")){
                    System.out.println(queue.Pop());
                }else if(part1.equals("SIZE")){
                    System.out.println(queue.count);
                }else if(part1.equals("CLEAR")){
                    queue.Clear();
                }
                op--;
            }
            n--;

        }
    }


    public static class Queue{
        private int[] data;
        private int front;
        private int rear;
//        private int size;
        private int count;

        public Queue(int size){
//            this.size = size;
            front = 0;
            rear = -1;
            data = new int[size];
            count = 0;
        }

        public void Push(int value){
            data[++rear] = value;
            count ++;
        }

        public int Top(){
            return data[rear];
        }

        public boolean isEmpty(){
            return count == 0;
        }

        public int Pop(){
            if(isEmpty()){
                return -1;
            }
            return data[rear--];
        }

        public void Clear(){
            front = 0;
            rear = -1;
            count = 0;
        }


    }
}

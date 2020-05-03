package com.hehe.Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程间通信的模型有两种：共享内存 和 消息传递，以下方式都是基本这两种模型来实现的。我们来基本一道面试常见的题目来分析：
 */

/**
 * 题目：有两个线程A、B，A线程向一个集合里面依次添加元素"abc"字符串，一共添加十次，当添加到第五次的时候，
 * 希望B线程能够收到A线程的通知，然后B线程执行相关的业务操作。
 */

/**
 * 实现了同步！！！！！
 */
public class TestSync_volatile {
    // 定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
    /**
     * 使用 volatile 关键字
     * 基于 volatile 关键字来实现线程间相互通信是使用共享内存的思想，大致意思就是多个线程同时监听一个变量，当这个变量发生变化的时候
     * 线程能够感知并执行相应的业务。这也是最简单的一种实现方式
     */
    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5)
                    notice = true;
            }
        });


        // 实现线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
                }
            }
        });


        //　需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再启动线程A
        threadA.start();
    }
}

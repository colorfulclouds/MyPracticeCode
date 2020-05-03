package com.hehe.Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Object类的wait() 和 notify() 方法
 * 众所周知，Object类提供了线程间通信的方法：wait()、notify()、notifyaAl()，它们是多线程通信的基础，而这种实现方式的思想
 * 自然是线程间通信。
 */

public class TestSync_wait {
    public static void main(String[] args) {
        // 定义一个锁对象
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    list.add("abc");
                    System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 5)
                        lock.notify();// 唤醒B线程
                }
            }
        });
        // 实现线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B收到通知，开始执行自己的业务...");
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


//线程A向list中添加一个元素，此时list中的元素个数为：1
//线程A向list中添加一个元素，此时list中的元素个数为：2
//线程A向list中添加一个元素，此时list中的元素个数为：3
//线程A向list中添加一个元素，此时list中的元素个数为：4
//线程A向list中添加一个元素，此时list中的元素个数为：5
//线程A向list中添加一个元素，此时list中的元素个数为：6
//线程A向list中添加一个元素，此时list中的元素个数为：7
//线程A向list中添加一个元素，此时list中的元素个数为：8
//线程A向list中添加一个元素，此时list中的元素个数为：9
//线程A向list中添加一个元素，此时list中的元素个数为：10
//线程B收到通知，开始执行自己的业务...

/*
* 由打印结果截图可知，在线程A发出notify()唤醒通知之后，依然是走完了自己线程的业务之后，线程B才开始执行，
* 这也正好说明了，notify()方法不释放锁，而wait()方法释放锁。
*
* */
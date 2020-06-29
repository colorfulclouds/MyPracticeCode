package com.hehe.Thread;

import javax.management.StandardEmitterMBean;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class _1Producer implements Runnable {
    BlockingQueue<String> queue;
    public _1Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            String tmp = "A Product,生产线程：" + Thread.currentThread().getName();
            System.out.println("I have made a product : " + Thread.currentThread().getName());
            queue.put(tmp); //队列满 阻塞当前线程
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}

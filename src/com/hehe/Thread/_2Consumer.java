package com.hehe.Thread;

import java.util.concurrent.BlockingQueue;

public class _2Consumer implements Runnable {
    BlockingQueue<String> queue;
    public _2Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

//    @lombok.SneakyThrows //??
    @Override
    public void run() {
        try{
            String tmp = queue.take(); //队列空 阻塞当前线程
            System.out.println(tmp);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

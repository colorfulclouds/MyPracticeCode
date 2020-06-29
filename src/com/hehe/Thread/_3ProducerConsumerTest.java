package com.hehe.Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class _3ProducerConsumerTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        _2Consumer consumer = new _2Consumer(queue);
        _1Producer producer = new _1Producer(queue);
        for (int i = 0; i < 100; i++) {
            new Thread(producer, "Producer " + (i + 1)).start();

            new Thread(consumer, "Consumer " + (i + 1)).start();

        }


    }

}

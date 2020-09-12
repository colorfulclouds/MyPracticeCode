package com.hehe.Thread;

import java.util.concurrent.*;


public class StartThread_1 {
    public static void main(String arg[]) {
        //1.继承thread类
        StartThread_1_Mythread mythread = new StartThread_1_Mythread();
        mythread.start();

        //2.实现runnable接口
        StartThread_1_MythreadRunable mythreadRunable = new StartThread_1_MythreadRunable();
        new Thread(mythreadRunable).start();

        //3.匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("3.我是通过匿名内部类方式启动的线程");
            }
        }).start();

        //4.使用线程池方式启动.(这里调用java并发包下的执行器类的静态的“新建固定的线程池”方法创建指定的线程池的数量)
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("4.我是通过线程池（调执行器的静态方法）方式启动的线程");
            }
        });
        pool.shutdown();

        //5.实现Callable接口，可以返回结果（）
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "5.我是通过实现Callable（）方法启动的线程，通过futureTask.get()方法得到的string";
            }
        });

        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
        }
    }


}


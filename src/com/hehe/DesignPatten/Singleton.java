package com.hehe.DesignPatten;


/**
 *单例模式:
 * 是指在内存中只会创建且仅创建一次对象的设计模式。
 * 在程序中多次使用同一个对象且作用相同时，为了防止频繁地创建对象使得内存飙升，单例模式可以让程序仅在内存中创建一个对象，让所有需要调用的地方都共享这一单例对象
 */

/**
 * 单例模式有两种类型：
 *   懒汉式：在真正需要使用对象时才去创建该单例类对象
 *   饿汉式：在类加载时已经创建好该单例对象，等待被程序使用
 */
public class Singleton {

    /**
     * 懒汉式
     */
    private static volatile Singleton singleton; //volatile 防指令重排
// 使用 volatile 防止指令重排:
// 因为在创建一个对象，在 JVM 中会经过三步：
// (1）为 singleton 分配内存空间
//（2）初始化 singleton 对象
//（3）将 singleton 指向分配好的内存空间


    private Singleton(){}

    /**
     * 线程不安全
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 饿汉式
     * 饿汉式在类加载时已经创建好该对象，在程序调用时直接返回该单例对象即可
     *
     */
//    private static final Singleton singleton = new Singleton(); //final 饿汉式创建单例模式

//    private Singleton(){}

//    public static Singleton getInstance() {
//        return singleton;
//    }

    //懒汉式如何保证只创建一个对象

    /**
     * 线程安全 -1
     * @return
     */
    public static synchronized Singleton getInstance01() { //synchronized
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


    /**
     * 线程安全 -2
     * @return
     */
    public static Singleton getInstance02() {
        synchronized(Singleton.class) { //synchronized
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

//优化性能：目标是如果没有实例化对象则加锁创建，如果已经实例化了，则不需要加锁，直接获取实例

    /**
     * 并发安全 性能高
     * 因为需要两次判空，且对类对象加锁，该懒汉式写法也被称为：Double Check（双重校验） + Lock（加锁）
     * @return
     */
    public static  Singleton getInstance03() {
        if (singleton == null) { //空时去抢锁
            synchronized(Singleton.class) { //synchronized
                if (singleton == null) {  //多个线程尝试争抢同一个锁，只有一个线程争抢成功，第一个获取到锁的线程会再次判断singleton 是否为空，因为 singleton 有可能已经被之前的线程实例化
                    singleton = new Singleton();
                }
            }
        } //否则直接返回
        return singleton;
    }




}



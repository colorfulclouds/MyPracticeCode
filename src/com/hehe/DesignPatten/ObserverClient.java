package com.hehe.DesignPatten;

import java.util.Observable;
import java.util.Vector;

/**
 * 被观察者：抽象类
 */
abstract class Subject {
    /**
     * 用来存放观察者对象的Vector容器（之所以使用Vector而不使用List，是因为多线程操作时，Vector在是安全的，而List则是不安全的），这个Vector容器是被观察者类的核心
     */
    private Vector<Observer> obs = new Vector();

    public void addObserver(Observer obs){ //向这个容器中添加观察者对象
        this.obs.add(obs);
    }
    public void delObserver(Observer obs){ //从容器中移除观察者对象
        this.obs.remove(obs);
    }
    protected void notifyObserver(){ //依次调用观察者对象的对应方法
        for(Observer o: obs){
            o.update();
        }
    }

    public abstract void doSomething();

}

/**
 * 具体的被观察者：使用这个角色是为了便于扩展，可以在此角色中定义具体的业务逻辑
 */
class ConcreteSubject extends Subject {
    public void doSomething(){
        System.out.println("被观察者事件反生");
        this.notifyObserver();
    }
}


/**
 * 观察者：接口 update()方法
 */
interface Observer {
    public void update();
}

/**
 * 具体的观察者：观察者接口的具体实现，在这个角色中，将定义被观察者对象状态发生变化时所要处理的逻辑。
 */
class ConcreteObserver1 implements Observer {
    public void update() {
        System.out.println("观察者1收到信息，并进行处理。");
    }
}
class ConcreteObserver2 implements Observer {
    public void update() {
        System.out.println("观察者2收到信息，并进行处理。");
    }
}

/**
 * 观察者模式客户端
 */
public class ObserverClient {
        public static void main(String[] args){
            Subject sub = new ConcreteSubject();
            Observer ob1 = new ConcreteObserver1();
            Observer ob2 = new ConcreteObserver2();
            sub.addObserver(ob1); //添加观察者1
            sub.addObserver(ob2); //添加观察者2
            sub.doSomething();

            sub.delObserver(ob1);
            sub.doSomething();
        }

}

/**
 * 观察者与被观察者之间是属于----轻度的关联关系，并且是抽象耦合的-----，这样，对于两者来说都比较容易进行扩展。
 *
 * 观察者模式是一种常用的触发机制，它形成一条触发链，依次对各个观察者的方法进行处理。
 * 但同时，这也算是观察者模式一个缺点，由于是链式触发，当观察者比较多的时候，性能问题是比较令人担忧的。并且，在链式结构中，比较容易出现循环引用的错误，造成系统假死。
 */

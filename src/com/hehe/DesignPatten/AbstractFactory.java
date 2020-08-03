package com.hehe.DesignPatten;

interface IProduct1 {
    public void show();
}
interface IProduct2 {
    public void show();
}

class Product1 implements IProduct1 {
    public void show() {
        System.out.println("这是1型产品");
    }
}
class Product2 implements IProduct2 {
    public void show() {
        System.out.println("这是2型产品");
    }
}


interface IFactory01 {
    public IProduct1 createProduct1();
    public IProduct2 createProduct2();
}


class Factory01 implements IFactory01{
    public IProduct1 createProduct1() {
        return new Product1();
    }
    public IProduct2 createProduct2() {
        return new Product2();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        IFactory01 factory = new Factory01();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }
}

/**
 * 抽象工厂模式的优点：
 * 抽象工厂模式除了具有工厂方法模式的优点外，最主要的优点就是:  【可以在类的内部对产品族进行约束】。所谓的产品族，一般或多或少的都存在一定的关联，
 * 抽象工厂模式就可以在类内部对产品族的关联关系进行定义和描述，而不必专门引入一个新的类来进行管理。
 *
 * 抽象工厂模式的缺点：
 * 产品族的----扩展----将是一件十分费力的事情，假如产品族中需要增加一个新的产品，则几乎所有的工厂类都需要进行修改。所以使用抽象工厂模式时，对产品等级结构的划分是非常重要的。
 *
 * 适用场景：
 * 当-----需要创建的对象是一系列相互关联或相互依赖的产品族-----时，便可以使用抽象工厂模式。
 * 说的更明白一点，就是一个继承体系中，如果存在着多个等级结构（即存在着多个抽象类），并且分属各个等级结构中的实现类之间存在着一定的关联或者约束,
 * 就可以使用抽象工厂模式。假如各个等级结构中的实现类之间不存在关联或约束，则使用多个独立的工厂来对产品进行创建，则更合适一点。
 *
 *
 * 简单工厂和工厂和抽象工厂 在实际开发中可以相互转换
 * 抽象工厂模式与工厂方法模式的区别:
 *     抽象工厂模式是工厂方法模式的升级版本，他用来创建一组相关或者相互依赖的对象。【抽象工厂可以生产不同的产品】
 *     他与工厂方法模式的区别就在于，工厂方法模式针对的是一个产品等级结构；而抽象工厂模式则是针对的多个产品等级结构
 *
 *
 */







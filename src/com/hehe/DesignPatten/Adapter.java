package com.hehe.DesignPatten;


interface Duck { //鸭子
    void quack();
}

interface Turkey { //火鸡
    void gobble();
}

class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("gobble!");
    }
}

class WildDuck implements Duck{

    @Override
    public void quack() {
        System.out.println("quak!");
    }
}

/**
 * 将 Turkey 的 gobble() 方法适配成 Duck 的 quack() 方法,火鸡冒充鸭子
 */
class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}

public class Adapter {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);  //适配成了 Duck 的 quack() 方法（站在火鸡群里还是鸭叫）
        duck.quack();
    }
}


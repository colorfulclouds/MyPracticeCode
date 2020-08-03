package com.hehe.DesignPatten;


class Engine {
    public void getStyle() {
        System.out.println("这是汽车的发动机");
    }
}

class Underpan {
    public void getStyle() {
        System.out.println("这是汽车的底盘");
    }
}

class Wheel {
    public void getStyle() {
        System.out.println("这是汽车的轮胎");
    }
}

class ICar{
    Underpan underpan;
    Wheel wheel;
    Engine engine;
    ICar(Underpan underpan,Wheel wheel,Engine engine){
        this.underpan = underpan;
        this.wheel = wheel;
        this.engine = engine;
    }
    public void show(){
        underpan.getStyle();
        wheel.getStyle();
        engine.getStyle();
    }
}

interface IFactory {
    ICar createCar();
}

class Factory implements IFactory {

    public ICar createCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        ICar car = new ICar(underpan, wheel, engine);
        return car;
    }

}



public class FactoryClient {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        ICar car = factory.createCar();
        car.show();
    }

}


/**
 * 非工厂模式
 */
//class Client {
//    public static void main(String[] args) {
//        Engine engine = new Engine();
//        Underpan underpan = new Underpan();
//        Wheel wheel = new Wheel();
//        ICar car = new ICar(underpan, wheel, engine);
//        car.show();
//    }
//}



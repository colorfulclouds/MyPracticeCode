package com.hehe.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestCompare02 {

    static class Person {
        private String name;
        private int age;

        public Person(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }

        public void print() {
            System.out.println("name:" + name + "; age:" + age);
        }

//        @Override    //要不要都可以
        public String toString() {   //当输出该类对象时的各字段输出格式 自定义
            return "Person : age=" + age + ", name=" + name;
        }

    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        Person test1 = new Person(66, "xiaohua");
        Person test2 = new Person(30, "ming");
        Person test3 = new Person(18, "zhu");
        Person test4 = new Person(20, "gou");
        list.add(test4);
        list.add(test3);
        list.add(test2);
        list.add(test1);

//        test1.name.compareTo(test2.name);    //匿名比较器代码另写法

        //点睛处
        Collections.sort(list, new Comparator<Person>() {   // ArrayAndList.MaxPoints 有比较器的实现方法
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });

        //依次输出！
        for (Person s : list) {
            System.out.println(s.name);
        }
        //体会 toString 方法
        for (Object s : list) {
            System.out.println(s);
        }

    }


//    xiaohua
//    ming
//    gou
//    zhu
//    Person : age=66, name=xiaohua
//    Person : age=30, name=ming
//    Person : age=20, name=gou
//    Person : age=18, name=zhu
}

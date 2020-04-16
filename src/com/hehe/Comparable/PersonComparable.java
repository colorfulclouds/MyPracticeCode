package com.hehe.Comparable;

public class PersonComparable implements Comparable<PersonComparable> {
    public int age;
    public String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PersonComparable(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {   //当输出该类对象时的各字段输出格式 自定义
        return "Person : age=" + age + ", name=" + name;
    }


    //实现Comparable接口必须实现compareTo方法
    public int compareTo(PersonComparable o) {
        if (this.age == o.age && this.name == o.name) {
            return 0;
        } else if (this.age > o.age) {
//	    	System.out.println("this.age:"+this.age+"o.age:"+o.age);
            return 1;
        } else {
            return -1;
        }
    }


}
package com.hehe.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;

public class TestCompare extends TestCase{
    @Test
    public void test1(){
        List<Person> list = new ArrayList<Person>();
        Person test1=new Person(66,"????");
        Person test2=new Person(30,"????????");
        Person test3=new Person(18,"?????");
        Person test4=new Person(20,"?????");
        list.add(test4);
        list.add(test3);
        list.add(test2);
        list.add(test1);

        Collections.sort(list);

        for(Object s:list){
            System.out.println(s);
        }
    }
}
//Person : age=18, name=?????
//Person : age=20, name=?????
//Person : age=30, name=????????
//Person : age=66, name=????

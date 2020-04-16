package com.hehe.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;

public class TestCompare extends TestCase{
    @Test
    public void test1(){
        List<PersonComparable> list = new ArrayList<PersonComparable>();
        PersonComparable test1=new PersonComparable(66,"????");
        PersonComparable test2=new PersonComparable(30,"????????");
        PersonComparable test3=new PersonComparable(18,"?????");
        PersonComparable test4=new PersonComparable(20,"?????");
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

package com.hehe.Comparable;
import java.util.ArrayList;
import java.util.List;
//import org.junit.Test;
/**
 * @Test注解与TestCase的区别
 *
 * 继承TestCase：Junit3的方式，方法名以test为前缀
 *
 * @Test注解：Junit4的方式，方法上使用注解@Test
 *
 * p.s. :Junit4为了兼容性，jar包里打包的有Junit3的代码
 *
 * 如果还想使用Junit4的能力，依然继承TestCase类的时候
 * （可能如文中说的，可能继承它的一些断言方法）或者是其它外力原因不可更改，可以在测试类上加上注解@RunWith(JUnit4.class)
 * 显式指定使用Junit4
 */

//@RunWith(JUnit4.class)
public class TestCompare {  //extends TestCase
//    @Test
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
        list.sort(PersonComparable::compareTo);

//        Collections.sort(list);

        for(Object s:list){
            System.out.println(s);
        }
    }
}
//Person : age=18, name=?????
//Person : age=20, name=?????
//Person : age=30, name=????????
//Person : age=66, name=????

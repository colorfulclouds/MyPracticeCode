package test;

public class zf_me0716test {
    public static void main(String[] args) {
        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x.equals(y)); // true
        System.out.println(x == y); //false
        System.out.println("===================");
        Float xx = new Float(1.0);
        Float yy = new Float(1.0);

        Double zz = new Double(2.0);
        System.out.println(xx.equals(x)); //false
        System.out.println("===================");
        System.out.println(x.equals(xx)); //false
        System.out.println("===================");
        System.out.println(xx.equals(yy)); //true
        System.out.println(xx == yy); //false
        System.out.println(zz == (x+y));  //true

//        (Double)(11);
        System.out.println();

        //看源码了解到，如果使用封装类Equals判断两个变量是否相等，首先需要他们是同一个类型的(同是Double或者同是Integer)，如果是值相等，就是true
        //用 == 判断时，判断的是地址，如果有表达式参与，则比较的是值
        //Integer i= XXX 自动装箱，和Integer i= Integer.valueOf(10) 等价，范围在（-128~127）可以使用Integer缓冲池，超过此范围的自动装箱的两个数是不等的
        //Integer i= XXX 和 Integer.valueOf(XXX)区别是 new 每次都会new一个新的对象，而Integer.valueOf(XXX) 可能会用缓存池的对象


        System.out.println("-----------------------");
        Integer a = 1;
        Integer b = 1;
        Double c = 1.0;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}


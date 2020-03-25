package com.hehe.MagicAlgorithm;

//继承Number类，需要实现int，double,float,long等数据类型，本例只实现int型
//Rational 类需要实现加减乘除的算法，本例只实现加法
public class Rational extends Number implements Comparable<Rational>{
    @Override
    public int compareTo(Rational o) {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    /**
     * @param args
     */
    private long num=0;
    private long den=1;
    private float doubleValue;
    public  Rational(){
        this(0,1);
    }

    public Rational(long num, long den) {
        long gcd=gcd(num,den);
        this.num=((den>0)?1:-1)*num/gcd;
        this.den=Math.abs(den)/gcd;
    }


    //最小公约数的函数的实现
    private static long gcd(long n, long d) {
        long n1=Math.abs(n);
        long n2=Math.abs(d);
        int k=1,gcd=2;
        while(k<=n1 && k<=n2){
            if(n1/k==0 && n2/k==0)
                gcd=k;
        }
        return gcd;
    }

    public static void main(String[] args) {
        Rational r1=new Rational();
        Rational r2=new Rational(6,2);
//        System.out.println(r1+"+"+r2+"="+(r1).add(r2));

    }

}

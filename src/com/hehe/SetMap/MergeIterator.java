package com.hehe.SetMap;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 以迭代器为参数的迭代器  案例
 * Set可以去重，而TreeSet可以排序
 * MockIterator为主要功能代码类
 * MergeIterator为  以迭代器为参数的迭代器  的代码类
 */
class MergeIterator implements Iterator<Integer> {

    /**
     * 以迭代器为参数的迭代器
     * @param a
     * @param b
     */
    public MergeIterator(Iterator<Integer> a, Iterator<Integer> b) {
        // Set可以去重，而TreeSet可以排序
        Set<Integer> set = new TreeSet<Integer>();
        while (a.hasNext()) {
            set.add(a.next());
        }
        while (b.hasNext()) {
            set.add(b.next());
        }

        Iterator<Integer> value = set.iterator();
        while (value.hasNext()) {
            int s = value.next();
            System.out.print(s);
            if (value.hasNext())
                System.out.print(" ");
        }
    }

    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    public Integer next() {
        // TODO Auto-generated method stub
        return null;
    }

    public void remove() {
        // TODO Auto-generated method stub

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        MockIterator ita = new MockIterator(a, b);
        MockIterator itb = new MockIterator(c, d);
        Iterator<Integer> it = new MergeIterator(ita, itb);
    }
}

/*代码解析：
 * 是内部类
 * 实现迭代器接口，参数（步长，终止值），也返回current
 * 有hasNext()判断是否有下一个数
 * 有next()返回下一个current值是多少
 *
 * 输出示例：
 * 1 3
 * 3%1=0 0+1=1,1+1=2,2+1=3
 * 1 2 3
 *
 * 3 10
 * 10%3=1 1+3=4,4+3=7
 * 4 7 10
 *
 * 排列去重：1 2 3 4 7 10
 * */
class MockIterator implements Iterator<Integer> {

    int current, step, endValue;

    public MockIterator(int step, int endValue) {
        this.step = step;
        this.endValue = endValue;
        this.current = endValue % step;    //当前值默认为终止值取余步长
    }

    public boolean hasNext() {
        // TODO Auto-generated method stub
        return this.current < this.endValue;
    }

    public Integer next() {
        // TODO Auto-generated method stub
        return this.current += this.step;
    }

    public void remove() {
        // TODO Auto-generated method stub

    }

}
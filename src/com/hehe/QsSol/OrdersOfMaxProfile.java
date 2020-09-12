package com.hehe.QsSol;
import java.util.*;
//5 2
//5 10  //a = 5  b=10  订单编号 1
//8 9
//1 4
//7 9
//6 10

//2 5

/**
 * 描述：
 * 5组数 表示5个订单，订单价值是 w = a + 2 * b;
 * 求最大收益下的 m 订单编号（相同收益的小订单号在前）
 *
 */

public class OrdersOfMaxProfile {
    static class Order{
        int id;
        int vl;
        Order(int i,int v){
            id = i;
            vl = v;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        int[] orders = new int[n];
        TreeMap<Integer, LinkedList<Order>> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int a,b,w;

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            w = a + 2*b;
            if(!tm.containsKey(w)){
                LinkedList<Order> l = new LinkedList<Order>();
                tm.put(w,l);
            }
            tm.get(w).addLast(new Order(i+1,w));
        }
        int index = 0;
        Set<Integer> keySet = tm.keySet();
        Iterator<Integer> iter = keySet.iterator();
        int[]  ids = new int[m];
        while(index < m && iter.hasNext()){
            int value = iter.next();
            LinkedList<Order> list = tm.get(value);
            while(!list.isEmpty()){
                ids[index] = list.removeFirst().id;
                index++;
                if(index >= m)
                    break;
            }
        }

        Arrays.sort(ids);
        for (int j = 0; j < m; j++) {
            if( j == 0)
                System.out.print(ids[j]);
            else
                System.out.print(" " + ids[j]);
        }



    }
}

package com.hehe.LRU;

import java.util.*;

public class LRU {
    public static class CacheLRU{
        static Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        static Queue<Integer> queue = new LinkedList<>();
        public static int size ;
        public CacheLRU(int num){
            this.size = num;
        }

        //get函数
        public  void get(int key) {
            if (maps.containsKey(key)) {
                queue.remove(key);
                queue.add(key);
                System.out.print("取到元素： " + maps.get(key));
            } else {
                System.out.println("-1");
            }
        }

        //put函数
        public  void put(int key, int val) {
            if (maps.containsKey(key)) { //是否已包含元素
                maps.put(key, val);
                queue.remove(key); //====queue双操作=====
                queue.add(key);
                System.out.println("包含该元素，重新添加: " + key);
            } else {
                if (maps.size() < size) { //判断是否超过容量 否
                    maps.put(key,val);
                    //queue.remove(key);  //====queue双操作=====
                    queue.add(key);
                    System.out.println("不包含该元素，有位置，直接添加: " + key);
                } else {//超出缓存容量,选择最近最久未使用的
                    Integer k = queue.poll();
                    //maps.remove(k);
                    //maps.put(key, val);
                    maps.put(key,val);
                    queue.add(key);
                    System.out.println("不包含该元素，超容移除,并放置新元素: " + key);
                }
            }
        }
    }


    public static void main(String[] args) {
        CacheLRU lru = new CacheLRU(3);
        lru.get(1);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.get(1);
        lru.put(4,4);
        lru.get(2);
    }



//3
//5
//p 1 2
//p 2 3
//g 1
//p 4 5
//g 1
//-1
//-1

}

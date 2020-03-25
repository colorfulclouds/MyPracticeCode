package com.hehe.SetMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*HashMap 和 迭代器
 * 3种方法
 * */
public class MapIteratorTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "hehe");
        map.put(2, "Mr.Right");
        // 假设map是HashMap对象
        // map中的key是String类型，value是Integer类型

		printHashMap_X(map);
		printHashMap_2(map);
        printHashMap_3(map);
        printHashMap_4(map);

//        1 hehe
//        2 Mr.Right
//        Key:1,Value:hehe
//        Key:2,Value:Mr.Right
//        1 hehe
//        2 Mr.Right
//        1 hehe
//        2 Mr.Right

    }

    public static void printHashMap_2(HashMap<Integer, String> map) {

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("Key:" + e.getKey() + "," + "Value:" + e.getValue());
        }
    }


    public static void printHashMap_3(HashMap<Integer, String> map) {

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer e = (Integer) it.next();
            String value = map.get(e);
            System.out.println(e + " " + value);
        }
    }


    public static void printHashMap_4(HashMap<Integer, String> map) {

        for (Integer keys : map.keySet()) {
            System.out.println(keys + " " + map.get(keys));
        }
    }


    public static void printHashMap_X(HashMap<Integer, String> map) {

        Iterator it = map.entrySet().iterator();
        Integer key = null;
        String in = null;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            // 获取key
            key = (Integer) e.getKey();
            // 获取value
            in = (String) e.getValue();
            System.out.println(key + " " + in);
        }
    }


}
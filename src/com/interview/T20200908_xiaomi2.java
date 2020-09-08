package com.interview;

import java.util.HashMap;

public class T20200908_xiaomi2 {
    public static void main(String[] args) {
        String[] po = {"4","A","3","K"};
        String[] res = pokersort(po);
        for(String i : res)
            System.out.print(i+" ");
    }

    static String[] pokersort(String[] pokers) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("3",0);
        map.put("4",1);
        map.put("5",2);
        map.put("6",3);
        map.put("7",4);
        map.put("8",5);
        map.put("9",6);
        map.put("10",7);
        map.put("J",8);
        map.put("Q",9);
        map.put("K",10);
        map.put("A",11);
        map.put("2",12);

        HashMap<Integer,String> reverse = new HashMap<>();
        reverse.put(0,"3");
        reverse.put(1,"4");
        reverse.put(2,"5");
        reverse.put(3,"6");
        reverse.put(4,"7");
        reverse.put(5,"8");
        reverse.put(6,"9");
        reverse.put(7,"10");
        reverse.put(8,"J");
        reverse.put(9,"Q");
        reverse.put(10,"K");
        reverse.put(11,"A");
        reverse.put(12,"2");
        int[] tmp = new int[13];
        for (int i = 0; i < pokers.length; i++) {
            tmp[map.get(pokers[i])]++;
        }
        String[] res = new String[pokers.length];
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] != 0)
                res[index++] = reverse.get(i);
        }
        return res;
    }

}

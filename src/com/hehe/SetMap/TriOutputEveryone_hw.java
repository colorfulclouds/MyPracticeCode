package com.hehe.SetMap;
import java.util.*;

public class TriOutputEveryone_hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        Set<Integer> set = new HashSet();
        List<Integer> ll = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            int ii = Integer.parseInt(in[i]);
            if(!set.contains(ii)){
                ll.add(ii);
            }
            set.add(ii);
        }
        for (int v: ll ) {
            System.out.print(v + " " + v + " "+ v + " ");
        }
    }

}
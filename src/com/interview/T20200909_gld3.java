package com.interview;

//import javax.jnlp.IntegrationService;
import java.util.*;

public class T20200909_gld3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
//        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
//            list.add(sc.nextInt());
        }
        List<Integer> res = sol(arr);
        for (int i = 0; i < res.size(); i++) {
            if(i == res.size()-1)
                System.out.printf(res.get(i)+"");
            else
                System.out.printf(res.get(i)+" ");
        }
    }

    public static List<Integer> sol(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int m : nums)
            list.add(m);
        Iterator<Integer> iterator = list.iterator();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(iterator.hasNext())
            queue.offer(iterator.next());
        for (int n = 0; n < queue.size(); n++) {
            int min = queue.poll();
            int count = 0;
            int p1 = 0;
            int p2 = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == min){
                    count++;
                    if(count==1)
                        p1 = i;
                    if(count == 2){
                        p2 = i;
                        break;
                    }
                }
            }
            if(count == 2){
                list.set(p2,list.get(p2)*2);
                list.remove(p1);
                PriorityQueue<Integer> queue2 = new PriorityQueue<>();
                for (int j = 0; j < list.size(); j++) {
                    queue2.offer(list.get(j));
                    queue = queue2;
                }
            }
            count = 0;
            n = 0;
        }
        return list;
    }
}

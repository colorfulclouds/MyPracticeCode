package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * huangwei
 */
public class Sol0802_pdd2_1 {
    public static int N;
    public static int[][] data;
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        data = new int[N][6];
        for(int i = 0;i<N;i++){
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
            data[i][3] = sc.nextInt();
            data[i][4] = sc.nextInt();
            data[i][5] = sc.nextInt();
        }
        parent = new int[N];
        for(int i = 0;i<N;i++){
            parent[i] = i;
        }

        //判断是否能旋转到
        for(int i = 0;i<N;i++){
            for(int j = i+1;j<N;j++){
                if(isSame(i,j)){
                    union(i,j);
                    continue;
                }else if(find(i)== find(j)){
                    continue;
                }else if(isTheSameType(i,j)){
                    union(i,j);
                }
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<parent.length;i++){
            if(!map.containsKey(parent[i])){
                map.put(parent[i],1);
            }else{
                map.put(parent[i],map.get(parent[i])+1);
            }
        }

        System.out.println(map.size());
        int[] result = new int[map.size()];
        int index = 0;
        for(int key:map.keySet()){
            result[index] = map.get(key);
            index++;
        }

        Arrays.sort(result);
        for(int num : result){
            System.out.printf(num + " ");
        }
    }

    public static boolean isTheSameType(int row1,int row2){
        for(int i = 0;i<4;i++){
            int time1 = i;
            for(int times = time1;times>0;times--){
                leftToRight(row2);
                if(isSame(row1,row2)){
                    return true;
                }
            }
            for(int j = 0;j<=4;j++){
                int time2 = j;
                for(int times = time2;times>0;times--){
                    frontToBack(row2);
                    if(isSame(row1,row2)){
                        return true;
                    }
                }
                for(int k = 0;k<=2;k++){
                    int time3 = k;
                    for(int times = time3;times>0;times--){
                        upToLow(row2);
                        if(isSame(row1,row2)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSame(int row1 , int row2){
        for(int i = 0;i<6;i++){
            if(data[row1][i] != data[row2][i]){
                return false;
            }
        }
        return true;
    }

    public static int find(int p){
        return parent[p];
    }

    public static void union(int p , int q){
        int pid = find(p);
        int qid = find(q);
        if(pid == qid){
            return;
        }

        for(int i = 0;i<parent.length;i++){
            if(parent[i] == pid){
                parent[i] = qid;
            }
        }
    }

    //左右旋转
    public static void leftToRight(int row){
        swap(data[row],2,4);
        swap(data[row],2,3 );
        swap(data[row],2,5);
    }

    //前后旋转
    public static void frontToBack(int row){
        swap(data[row],0,4);
        swap(data[row],5,0);
        swap(data[row],1,5);
    }

    public static void upToLow(int row){
        swap(data[row],0,1);
        swap(data[row],4,5);
    }
    public static void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
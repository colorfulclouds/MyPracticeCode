package com.interview;

public class Main_mt {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        //System.out.println("Hello World!");
        int[] arr = {1,2,3,3,4};
        int index = Location(arr,3);
        System.out.println(index);


    }
    public static int Location(int[] arr,int target){
        if(arr.length <= 0)
            return -1;

        int start = 0;
        int end = arr.length;
        int mid = (start + (end-start))/2;  //1、改进
        while(start < end){
            if(arr[mid] == target){
                if( arr[mid-1] == target)
                    end = mid;
                else if((arr[mid-1] != target && mid>0) || mid == 0) //2、越界错误更改
                    return mid;
            }
            else if(arr[mid] < target)
                start = mid;
            else
                end = mid;
        }
        return -1;
    }
}

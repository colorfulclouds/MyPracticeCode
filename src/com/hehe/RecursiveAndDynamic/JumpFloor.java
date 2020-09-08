package com.hehe.RecursiveAndDynamic;

import java.util.ArrayList;

public class JumpFloor {
    public static void main(String[] args) {
        //比较倾向于找规律的解法，f(1) = 1, f(2) = 2, f(3) = 3, f(4) = 5，  可以总结出f(n) = f(n-1) + f(n-2)的规律，但是为什么会出现这样的规律呢？
        // 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6，
        // 其他的不能从3跳到6什么的啦，所以最后就是f(6) = f(5) + f(4)；这样子也很好理解变态跳台阶的问题了
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloorII(3));

        System.out.println(jumpFloorIII(10));
        System.out.println(jumpFloorIIII(10));

    }

    /**
     * 初级跳台阶
     * @param n
     * @return
     */
    public static long jumpFloor(int n){
        if(n<=0)
            return 0;
        if(n<=2)
            return n;
        long[] f = {1,2,0};
        for (int i = 2; i < n; i++) {
            f[2] = f[1] + f[0];
            f[0] = f[1];
            f[1] = f[2];
        }
        return f[2];
    }


    //f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    //f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    // 可以得出：
    // f(n) = 2*f(n-1)

    /**
     * 变态跳台阶
     * @param target
     * @return
     */
    public static int jumpFloorII(int target) {

        return 1<<(target-1);
    }

    /**
     * 跳台阶 每次一步或者两步 且要求不能有连续的两步
     * @param n
     * @return
     */
    public static int jumpFloorIII(int n){
        if(n <= 4)
            return n;
        int[] arr= {1,2,3,4};
        while(n > 0){
            int tmp = arr[0] + arr[1] + arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[3];
            arr[3] = tmp;
            n -= 1;
        }
        return arr[3];
    }

    /**
     * 复杂度高 没通过字节的笔试
     * @param n
     * @return
     */
    public static int jumpFloorIIII(int n){
        if(n <= 4)
            return n;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int size = 0;
        while(n > 0){
            size = list.size();
            int tmp = list.get(size-2) + list.get(size-3) + list.get(size -4);
            list.add(tmp);
            n -= 1;
        }
        return list.get(list.size() - 1);
    }

}

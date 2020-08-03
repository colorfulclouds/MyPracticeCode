package test;

import java.util.Scanner;


/**
 *
 * 10 4 // 距离终点10, 还能走4步
 * 6 3 3 3 // 每次分别走 6 3 3 3步
 *
 * 将返回 1 2 // 距离终点距离1, 往回走了2次
 */
public class Sol0802_pdd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); //距离终点的距离
        int N = sc.nextInt(); //还能走四次
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) { //每次的步数
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int cur = 0;
        if(K == 0){ //特殊情况的处理
            System.out.println("p");
            return;
        }

        for (int i = 0; i < N; i++) {
            cur += arr[i];
            if(cur == K && i < N-1){  //要求在第N步之前到达的返回P
                System.out.println("P");
                return;
            }
            else if(cur > K){
                cur = 2*K - cur; //K - (cur % 3);  //k - (cur - k)
                count++;
            }
        }
        System.out.println(K-cur + " " + count);



// AC的牛客网友的代码
//            Scanner in = new Scanner(System.in);
//            int distance = in.nextInt(); // 距离终点距离
//            int count = in.nextInt(); // 还能走多少步
//            if (distance == 0) {
//                System.out.println("paradox");
//            }
//            int ansCount = 0; // 折返次数
//            while (count-- > 0) {
//                int num = in.nextInt();
//                if (num < distance) { // 未到终点
//                    distance -= num;
//                } else if (num > distance) { // 折返
//                    ansCount++;
//                    distance = num - distance;
//                } else {
//                    distance -= ansCount; // 最后到达终点需要返回距离0和次数, 而不是paradox
//                    if (count > 0) {
//                        System.out.println("paradox");
//                        return;
//                    }
//                }
//            }
//            System.out.println(distance + " " + ansCount);


        }
}


//3 2
//4 6
//5 2   ???

//3 2
//4 4
//3 2  正确的

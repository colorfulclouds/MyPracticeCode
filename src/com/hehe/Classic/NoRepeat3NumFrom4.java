package com.hehe.Classic;

/**
 * 4个数选三个 组成不重复的三位数
 */
public class NoRepeat3NumFrom4 {

    public static void main(String[] args) {
        int count=0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (i != j) {
                    for (int k = 1; k < 5; k++) {
                        if(i!=j && j!=k && i!= k){
                            System.out.print(i*100+j*10 +k +" ");

                            count++;
                            if(count%5 == 0)
                                System.out.println();
                        }
                    }
                }
            }
        }
    }
}

// 123 124 132 134 142 143 213 214 231 234 241 243 312 314 321 324 341 342 412 413 421 423 431 432

//123 124 132 134 142
//143 213 214 231 234
//241 243 312 314 321
//324 341 342 412 413
//421 423 431 432

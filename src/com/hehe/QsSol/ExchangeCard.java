package com.hehe.QsSol;

public class ExchangeCard {
    /**
     * 交换两个人手上的牌，使两者的总数相等（不含大小王）
     *(找到一个即可)
     */
    public static void main(String[] args) {
//        int[] a = {4,2,2};
//        int[] b = {2,4,4};
        int[] a = {2,5,2};
        int[] b = {5,5,5};
        exchangeCard(a,b);
    }

    public static int sum(int[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void exchangeCard(int[] a,int[] b){
        for (int i = 0; i < a.length; i++) {
            int temp_a = a[i];
            for (int j = 0; j < b.length; j++) {
                int temp_b = b[j];
                b[j] = temp_a;
                a[i] = temp_b;
                if (sum(a) == sum(b)) {
                    System.out.println("[" + temp_a + "," + temp_b + "]");
                    break;
                }else{
                    a[i] = temp_b;
                    b[j] = temp_a;
                }
            }
        }
    }

}

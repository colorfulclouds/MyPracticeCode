package com.hehe.Classic;

//package Jianzhi_Offer;

/**数值的整数次方  （不考虑大数）
 *
 */
public class Power {

    public static double Powers(double base,int exponent){
        //**
        if((base == 0) && (exponent < 0))
            return -1;

        //指数可能为负数
        int absexponent = exponent;
        if(exponent < 0){
            absexponent = -exponent;
        }
        double result = PowerWithUnsignedExponent(base, absexponent);
        if(exponent < 0){
            result = 1.0/result;
        }

        return result;
    }

    //**优化后的指数运算
    public static double PowerWithUnsignedExponent(double base,int exponent) {
        if(exponent == 1)
            return base;
        if(exponent == 0)
            return 1;

        //exponent 右移代表除运算
        double result = PowerWithUnsignedExponent(base, exponent>>1);
        result *= result;

        //判断exponent是奇数还是偶数 奇数需要最后再乘以底数
        //位运算代替求余运算符
        //0x1  与  001  与 1
        if((exponent & 1) == 1)
            result *= base;

        return result;
    }


    public static void main(String[] args) {
        double result = Powers(2, -2);
        System.out.println(result);
    }

}

/*&运算
 * 1010 & 0001 == 0
 * 1011 & 0001 == 1
 *
 *
 * base为0
 * */


package com.hehe.Classic;

//package Jianzhi_Offer;

/**数值的整数次方  （不考虑大数）
 *
 */
public class Power {

    public static double Powers(double base,int exponent){
        //不合法情况
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
        //=============================================================================
        //exponent 右移代表除运算
        double result = PowerWithUnsignedExponent(base, exponent>>1);
        result *= result;

        //判断exponent是奇数还是偶数 奇数需要最后再乘以底数
        //位运算代替求余运算符 判断一个数是奇数还是偶数
        //0x1  与  001  与 1
        if((exponent & 1) == 1)
            result *= base;
        //=============================================================================

        return result;
    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * hehe
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if(base == 0 && exponent < 0) //非法情况
            return -1.0;
//        if(base == 0 && exponent > 0) //合法结果等于0
//            return 0.0;

        int absExponent = exponent < 0 ? -exponent : exponent;
        double res = 0;

        if (absExponent % 2 == 0)
            res = PowerCore(base, absExponent);
        else if(absExponent % 2 != 0)
            res =  PowerCore(base, absExponent) * base; //底数为负 双倍消单倍乘 无需处理

        if(exponent < 0){ //指数为负 结果求倒
            res = 1.0 / res;
        }
        return res;
    }


    public static double PowerCore(double base, int exponent) {
        if (exponent == 1)
            return base;
        return PowerCore(base, exponent / 2) * PowerCore(base, exponent / 2);

    }

    public static void main(String[] args) {
        double result01 = Powers(-2, 3);
        System.out.println(result01);
        double result02 = Powers(0, 3);
        System.out.println(result02);
        double result03 = Powers(0, -3);
        System.out.println(result03);
        double result04 = Powers(-2, -3);
        System.out.println(result04);

        System.out.println("+++++++++");
        double result1 = Power(-2, 3);
        System.out.println(result1);
        double result2 = Power(0, 3);
        System.out.println(result2);
        double result3 = Power(0, -3);
        System.out.println(result3);
        double result4 = Power(-2, -3);
        System.out.println(result4);
    }

}

/*&运算
 * 1010 & 0001 == 0
 * 1011 & 0001 == 1
 *
 *
 * base为0
 * */


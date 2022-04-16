package com.hehe.HuaWei;

public class LegalStringCheck {
    public static void main(String[] args) {

        System.out.println(legalStringCheck("aga’-="));
        System.out.println(legalStringCheck("c"));
    }

    // 校验字符串中是否含有非法字符
    public static String legalStringCheck(String content) {
        String illegal = "`-~_!#%^&*=+\\|{};:'\",<>/?○";
        char isLegalChar = 't';
        StringBuilder stringBuilder = new StringBuilder("");
        //L1:
        for (int i = 0; i < content.length(); i++) {
            for (int j = 0; j < illegal.length(); j++) {
                if (content.charAt(i) == illegal.charAt(j)) {
                    isLegalChar = content.charAt(i);
                    //有不符合项就退出循环
                    //break L1;
                    //提示出文件名称中有哪些不合规字符串
                    stringBuilder.append(content.charAt(i));
                }
            }
        }
        //return isLegalChar ;
        return stringBuilder.toString();
    }

}

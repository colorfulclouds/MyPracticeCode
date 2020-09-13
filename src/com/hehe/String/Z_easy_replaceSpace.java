package com.hehe.String;

/**
 * 字符串中的空格替换成  "%20"
 *
 */
public class Z_easy_replaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are family.")));
    }

    public static String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <str.length(); i++) {
            if(String.valueOf(str.charAt(i)).equals(" ")){
                sb.append("%20");
            }else
                sb.append(str.charAt(i));
        }
        return sb.toString();

    }


    /**
     * 数组类型的 从尾到头复制 遇到空格插入
     *
     * 见 package com.hehe.ArrayAndList.replaceBlank_easy;
     */
}

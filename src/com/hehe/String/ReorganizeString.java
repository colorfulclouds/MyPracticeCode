package com.hehe.String;

/**
 *重组字符串 若能相同元素的不相邻 即为可重组字符串
 */
public class ReorganizeString {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String s = "zzzzaabbb";
//        char[] c = s.toCharArray();
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String S) {
        int[] arr = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a'] ++;
        }
        // 找出最多数量的字符在arr中的索引
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        int maxNum = arr[index];
        if (S.length() % 2 == 0 && maxNum > S.length() / 2) {
            return "";
        }
        if (S.length() % 2 != 0 && maxNum > S.length() / 2 + 1) {
            return "";
        }
        // 可以输出的话,在偶数索引位置先设置最多数量的字符
        char[] newChar = new char[chars.length];
        int evenIndex = 0;
        while (arr[index] > 0) {
            newChar[evenIndex] = (char) (index + 'a');
            evenIndex += 2;
            arr[index]--;
        }
        // 在将其与字符添加到chars数组中
        int oddIndex = 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (evenIndex < newChar.length) {
                    newChar[evenIndex] = (char) (i + 'a');
                    evenIndex += 2;
                }else {
                    newChar[oddIndex] = (char) (i + 'a');
                    oddIndex += 2;
                }
                arr[i]--;
            }
        }

        return new String(newChar);
    }


    /**
     * 题目描述:
     * 给定n个字符串，请对n个字符串按照字典序排列。
     * 输入描述:
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     * 输出描述:
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     *
     * TreeSet是一个包含有序的且没有重复元素的集合(本题通过率 60%)  --不能用！！！
     * Collection
     * @param args
     */
//    int n = Integer.parseInt(sc.nextLine());
//    ArrayList<String> list = new ArrayList<>();
//        while (--n >= 0 && sc.hasNextLine()) {
//        String s = sc.nextLine();
//        list.add(s);
//    }
//        Collections.sort(list);
//        for (String s : list) {
//        System.out.println(s);
//    }



    //浮点数取整：小数点后数字大于5的要向前进1
//        float flt = sc.nextFloat();
//        int res = (int)(flt+0.5);
//        System.out.println(res);

    //数字符串中指定字符的个数
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine().toUpperCase();
//        int count = 0;
//        String str1 = sc.nextLine().toUpperCase();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == str1.charAt(0)){
//                count++;
//            }
//        }
//        System.out.println(count);
}

package com.hehe.HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LegalStringCheck01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> legal = new ArrayList<>();
        ArrayList<String> illegal = new ArrayList<>();
        ArrayList<String> leftShift = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.matches("\\s*")) {
                break;
            }
            inputs.add(line.replaceAll("\\s+", ""));
        }

        for (String input : inputs) {
            if (input.matches("[0-9a-zA-Z]+")) {
                if (!legal.contains(input)) {
                    legal.add(input);
                }
            } else {
                illegal.add(input);
            }
        }

        StringBuilder out = new StringBuilder();
        for (String str : legal) {
            out.append(str + " ");
        }
        System.out.println(out.toString());

        out = new StringBuilder();
        for (String str : illegal) {
            out.append(str + " ");
        }
        System.out.println(out.toString());

//        out = new StringBuilder();
//        for (String str : legal) {
//            String leftStr = left(str);
//            leftShift.add(leftStr);
//            out.append(leftStr + " ");
//        }
//        System.out.println(out.toString());

//        out = new StringBuilder();
//        Collections.sort(leftShift);
//        for (String str : leftShift) {
//            out.append(str + " ");
//        }
//        System.out.println(out.toString());
    }

    private static String left(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < 10; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}

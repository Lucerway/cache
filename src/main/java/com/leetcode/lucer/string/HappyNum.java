package com.leetcode.lucer.string;


import java.util.HashSet;

/**
 * 快乐数
 */
public class HappyNum {


    public static boolean isHappyNum(int a) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            a = doubleValue(a);
            if (a == 1) {
                return true;
            }
            if (set.contains(a)) {
                return false;
            }
            set.add(a);
        }
    }

    public static int doubleValue(int a) {
        String str = String.valueOf(a);
        char[] chars = str.toCharArray();
        int result = 0;
        for (int i = 0; i <= chars.length - 1; i++) {
            int temp = Integer.parseInt(String.valueOf(chars[i]));
            result += (temp * temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNum(19));
    }


}

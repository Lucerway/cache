package com.leetcode.lucer.string;

/**
 * 最长公共前缀
 *
 * @author: liuchuan
 */
public class LongestCommonPrefix {


    public static String longestCommonPrefix(String[] s) {
        if (s == null || s.length == 0) {
            return "";
        }
        if (s.length == 1) {
            return s[0];
        }


        String s1 = s[0];
        for (int i = 1; i < s.length; i++) {
            while (!s[i].startsWith(s1)) {
                if (s1.length() == 1) {
                    return "";
                }
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
        return s1;
    }

    public static void main(String[] args) {

//        System.out.println(longestCommonPrefix(null));
//
        String[] a = {"dog","racecar","car"};
//
        System.out.println(longestCommonPrefix(a));

   //     System.out.println(longestCommonPrefix(new String[]{"123", "q13"}));


    }


}
